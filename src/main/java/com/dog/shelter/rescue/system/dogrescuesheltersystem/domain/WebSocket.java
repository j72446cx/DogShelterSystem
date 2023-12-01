package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.StaffPageRepository;
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
//    private Long userId;
    private Long userId;
    private static ConcurrentHashMap<Long, Session> sessionMap = new ConcurrentHashMap<>();
//    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        WebSocket.applicationContext = context;
    }

    @OnOpen
    public void onOpen(@PathParam(value="token")String token, Session session) {
        log.info("[websocket connect successfully], connecting: {}", token);

        try{
        Claims claims = JwtUtils.parseJWT(token);
        userId = claims.get("id", Long.class);

        sessionMap.put(userId, session);

        log.info("Staff with ID: {} has connected", userId );}
        catch (Exception e){
            log.error("Error parsing JWT: {}", e.getMessage());
        }


    }

    @OnClose
    public void onClose(Session session) {
        sessionMap.remove(userId);
        log.info("[websocket closing]");

    }

    @OnMessage
    public void onMessage(String message) {
        log.info("[websocket info] received message: {}", message);

        try{
            JSONObject jsonMessage = new JSONObject(message);
            String action = jsonMessage.getString("type");
            String title = jsonMessage.optString("title", "none");
            Long senderId = jsonMessage.optLong("senderId", -1);
            Integer status = jsonMessage.optInt("status", 0);
            String msgContent = jsonMessage.getString("body");

            StaffPageService staffPageService =applicationContext.getBean(StaffPageService.class);
            Staff staff = staffPageService.getById(senderId);

            Message message1 = new Message();
            MessageService messageService = applicationContext.getBean(MessageService.class);
            message1.setBody(msgContent);
            message1.setTitle(title);
            message1.setSenderId(senderId);
            message1.setDate(LocalDateTime.now());
            message1.setType(action);
            message1.setStatus(status);

            if(!staff.getMiddleName().equals("")){
                message1.setSenderName(staff.getFirstName() + " " + staff.getMiddleName() + " " + staff.getLastName());
            }
            else{
                message1.setSenderName(staff.getFirstName() + " " + staff.getLastName());
            }


            switch (action) {
                case "sendToOne":
                    Long receiverId = jsonMessage.optLong("receiverId", -1);

                    // send message to the session
                    Session receiverSession = sessionMap.get(receiverId);
                    if (receiverSession != null && receiverSession.isOpen()){
                        receiverSession.getAsyncRemote().sendText(message);
                    }

                    Staff staff1 = staffPageService.getById(receiverId);
                    if(!staff1.getMiddleName().equals("")){
                        message1.setReceiverName(staff1.getFirstName() + " " + staff1.getMiddleName() + " " + staff1.getLastName());
                    }
                    else{
                        message1.setReceiverName(staff1.getFirstName() + " " + staff1.getLastName());
                    }

                    // save message to database
                    message1.setReceiverId(receiverId);
                    messageService.saveMessage(message1);



                    break;

                case "sendToMultiple":
                    JSONArray jsonArray = jsonMessage.optJSONArray("receiverId");
                    if (jsonArray != null){
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Long receiver = jsonArray.getLong(i);
                            Session receiverSe = sessionMap.get(receiver);
                            if (receiverSe != null && receiverSe.isOpen()){

                                log.info("Sending message to user_id: {}, with message: {}", receiver, message);
                                receiverSe.getAsyncRemote().sendText(message);
                            }

                            Staff staff2 = staffPageService.getById(receiver);
                            if(!staff2.getMiddleName().equals("")){
                                message1.setReceiverName(staff2.getFirstName() + " " + staff2.getMiddleName() + " " + staff2.getLastName());
                            }
                            else{
                                message1.setReceiverName(staff2.getFirstName() + " " + staff2.getLastName());
                            }


                            message1.setReceiverId(receiver);
                            messageService.saveMessage(message1);
                        }
                    }

                    break;

                default:

        }
    }catch (Exception e){};}

    @OnError
    public void onError(Throwable error) {

        System.out.println("Error: "+error.getMessage());
        error.printStackTrace();
    }

}
