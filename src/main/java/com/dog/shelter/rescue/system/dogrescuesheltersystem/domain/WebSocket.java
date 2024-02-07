package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.StaffPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.CustomerPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.MessageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.StaffPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.utils.JwtUtils;
import com.sun.xml.bind.v2.TODO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint("/webSocket/{token}")
public class WebSocket {

//    private Session session;
    private Long userId;

    private static ConcurrentHashMap<Long, Session> sessionMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Long, Session> adopterSessionMap = new ConcurrentHashMap<>();

//    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        WebSocket.applicationContext = context;
    }

    @OnOpen
    public void onOpen(@PathParam(value="token")String token, Session session) {
        log.info("[websocket connect successfully], connecting: {}", token);

        Claims claims = JwtUtils.parseJWT(token);
        String userType = claims.get("ms_role", String.class);

        if (userType.equals("staff")){
            userId = claims.get("id", Long.class);
            sessionMap.put(userId, session);
            log.info("Staff with ID: {} has connected", userId );
        }

        else if (("user").equals(userType)){
            userId = claims.get("id", Long.class);

            adopterSessionMap.put(userId, session);
            log.info("User with ID: {} has connected", userId);
        }

        session.getUserProperties().put("userId", userId);
        session.getUserProperties().put("userType", userType);



    }

    @OnClose
    public void onClose(Session session) {
        try{
        Long userId = (Long) session.getUserProperties().get("userId");
        String userType = (String) session.getUserProperties().get("userType");

        if ("staff".equals(userType)) {
            sessionMap.remove(userId);
            log.info("[websocket closing] Staff with ID: {} has disconnected", userId);
        } else if ("user".equals(userType)) {
            adopterSessionMap.remove(userId);
            log.info("[websocket closing] User with ID: {} has disconnected", userId);
        }}
        catch (Exception e) {
            log.error("Error during WebSocket close: {}", e.getMessage());
        }


    }

    @OnMessage
    public void onMessage(String message) {
        try{
            JSONObject jsonMessage = new JSONObject(message);
            String action = jsonMessage.getString("type");
            String title = jsonMessage.optString("title", "none");
            Long senderId = jsonMessage.optLong("senderId", -1);
            Integer status = jsonMessage.optInt("status", 0);
            String msgContent = jsonMessage.getString("body");

            Message message1 = new Message();
            MessageService messageService = applicationContext.getBean(MessageService.class);
            message1.setBody(msgContent);
            message1.setTitle(title);
            message1.setSenderId(senderId);
            message1.setDate(LocalDateTime.now());
            message1.setType(action);
            message1.setStatus(status);

            String receiverRole = jsonMessage.optString("receiverRole", "unknown");

            StaffPageService staffPageService = applicationContext.getBean(StaffPageService.class);
            CustomerPageService customerPageService = applicationContext.getBean(CustomerPageService.class);

            Staff sender = staffPageService.getById(senderId);
            if (sender.getMiddleName() != null && !sender.getMiddleName().equals("")){
                message1.setSenderName(sender.getFirstName() + " " + sender.getMiddleName() + " " + sender.getLastName());
            }
            else{
                message1.setSenderName(sender.getFirstName() + " " + sender.getLastName());
            }


            switch (action) {
                case "sendToOne":
                    Long receiverId = jsonMessage.optLong("receiverId", -1);




                    if ("user".equals(receiverRole)){

                        Session receiverSession = adopterSessionMap.get(receiverId);
                        if (receiverSession != null && receiverSession.isOpen()){
                            receiverSession.getAsyncRemote().sendText(message);
                        }

                        Customer customer = customerPageService.getById(receiverId);
                        log.info(" get by id result:{} ", customer.toString());

                        if (customer.getMiddleName() != null && !customer.getMiddleName().equals("")){
                            message1.setReceiverName(customer.getFirstName() + " " + customer.getMiddleName() + " " + customer.getLastName());
                        }
                        else{
                            message1.setReceiverName(customer.getFirstName() + " " + customer.getLastName());
                        }

                        message1.setReceiverId(receiverId);
                        messageService.saveMessageUser(message1);
                    }

                    else if ("staff".equals(receiverRole)){
                        // send message to the session
                        Session receiverSession = sessionMap.get(receiverId);
                        if (receiverSession != null && receiverSession.isOpen()){
                            receiverSession.getAsyncRemote().sendText(message);
                        }

                        Staff staff = staffPageService.getById(receiverId);
                        if(staff.getMiddleName() != null && !staff.getMiddleName().equals("")){
                            message1.setReceiverName(staff.getFirstName() + " " + staff.getMiddleName() + " " + staff.getLastName());
                        }
                        else{
                            message1.setReceiverName(staff.getFirstName() + " " + staff.getLastName());
                        }
                        message1.setReceiverId(receiverId);
                        messageService.saveMessage(message1);
                    }



                    break;

                case "sendToMultiple":
                    JSONArray jsonArray = jsonMessage.optJSONArray("receiverId");

                    if (jsonArray != null){
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Long receiver = jsonArray.getLong(i);

                            if ("user".equals(receiverRole)){
                                Session receiverSe = adopterSessionMap.get(receiver);
                                if (receiverSe != null && receiverSe.isOpen()){

                                    log.info("Sending message to user_id: {}, with message: {}", receiver, message);
                                    receiverSe.getAsyncRemote().sendText(message);
                                    Customer customer = customerPageService.getById(receiver);
                                    if(customer.getMiddleName()!= null && !customer.getMiddleName().equals("")){
                                        message1.setReceiverName(customer.getFirstName() + " " + customer.getMiddleName() + " " + customer.getLastName());
                                    }
                                    else{
                                        message1.setReceiverName(customer.getFirstName() + " " + customer.getLastName());
                                    }

                                    message1.setReceiverId(receiver);
                                    messageService.saveMessageUser(message1);

                                }
                            }
                            else if ("staff".equals(receiverRole)){
                                Session receiverSe = sessionMap.get(receiver);
                                if (receiverSe != null && receiverSe.isOpen()){

                                    log.info("Sending message to user_id: {}, with message: {}", receiver, message);
                                    receiverSe.getAsyncRemote().sendText(message);

                                    Staff staff2 = staffPageService.getById(receiver);
                                    if(staff2.getMiddleName() != null && !staff2.getMiddleName().equals("")){
                                        message1.setReceiverName(staff2.getFirstName() + " " + staff2.getMiddleName() + " " + staff2.getLastName());
                                    }
                                    else{
                                        message1.setReceiverName(staff2.getFirstName() + " " + staff2.getLastName());
                                    }

                                    message1.setReceiverId(receiver);
                                    messageService.saveMessage(message1);
                                }

                            }


                        }
                    }

                    break;

                default:

        }
    }catch (Exception e){
            log.info("Exception: {}", e);
        };}

    @OnError
    public void onError(Throwable error) {

        System.out.println("Error: "+error.getMessage());
        error.printStackTrace();
    }

}
