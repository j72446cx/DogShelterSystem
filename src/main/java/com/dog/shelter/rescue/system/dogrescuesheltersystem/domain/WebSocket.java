package com.dog.shelter.rescue.system.dogrescuesheltersystem.domain;


import com.dog.shelter.rescue.system.dogrescuesheltersystem.Repository.StaffPageRepository;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.Service.StaffPageService;
import com.dog.shelter.rescue.system.dogrescuesheltersystem.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@Slf4j
@ServerEndpoint("/webSocket/{token}")
public class WebSocket {

    private Session session;
    private Long userId;

    /**
     * Store sessions
     */
    private static ConcurrentHashMap<Long, Session> sessionMap = new ConcurrentHashMap<>();

    /**
     * Store Staffs
     */
    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="token")String token) {
        log.info("[websocket connect successfully], connecting: {}", token);
        try{
            Claims claims = JwtUtils.parseJWT(token);
            this.session = session;
            this.userId = claims.get("id",Long.class);

            if (sessionMap.containsKey(userId)){
                webSockets.stream()
                        .filter(ws -> ws.userId.equals(this.userId))
                        .findFirst().ifPresent(oldWebSocket -> onClose(oldWebSocket.session));
            }

            sessionMap.put(userId, session);
            webSockets.add(this);
            log.info("[websocket info] Total online: {}", sessionMap.size());
        }
        catch (ExpiredJwtException e){
            log.info("Session has been expired");
        }


    }

    /**
     * Close connection
     */
    @OnClose
    public void onClose(Session session) {
        try {
            webSockets.removeIf(ws -> ws.session.equals(session));
            sessionMap.values().removeIf(s -> s.equals(session));
//            webSockets.remove(this);
//            sessionMap.remove(this.userId);
            log.info("[websocket info] Disconnected，online total:"+webSockets.size());
        } catch (Exception e) {}
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("[websocket info] id: {} received message: {}", userId, message);

        try{
            JSONObject jsonMessage = new JSONObject(message);
            String action = jsonMessage.getString("action");
            String title = jsonMessage.optString("title");
            Long senderId = jsonMessage.optLong("senderId", -1);
            String timestamp = jsonMessage.optString("timestamp", "Unknown Time"); // Default timestamp if not provided
            String msgContent = jsonMessage.getString("message");

            JSONObject fullMessage = new JSONObject();
            fullMessage.put("title", title);
            fullMessage.put("senderId", senderId);
            fullMessage.put("timestamp", timestamp);
            fullMessage.put("message", msgContent);

            switch (action) {
                case "broadcast":
                    sendAllMessage(fullMessage.toString());
                    break;
                case "sendToOne":
                    sendOneMessage(jsonMessage.getLong("toUserId"), jsonMessage.getString("message"));
                    break;
                case "sendToMultiple":
                    JSONArray userIds = jsonMessage.getJSONArray("toUserId");
                    Long[] ids = new Long[userIds.length()];
                    for (int i = 0; i < userIds.length(); i++) {
                        ids[i] = userIds.getLong(i);
                    }
                    sendMoreMessage(ids, jsonMessage.getString("message"));
                    break;
                default:
                    // Handle unknown action
        }
    }catch (Error e){};}

    @OnError
    public void onError(Session session, Throwable error) {

        System.out.println("Error: "+error.getMessage());
        error.printStackTrace();
    }


    public void sendAllMessage(String message) {
        log.info("[websocket info]broadcast: "+message);
        for(WebSocket webSocket : webSockets) {
            try {
                if(webSocket.session.isOpen()) {
                    webSocket.session.getAsyncRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // 此为单点消息
    public void sendOneMessage(Long userId, String message) {
        Session session = sessionMap.get(userId);
        if (session != null&&session.isOpen()) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMoreMessage(Long[] userIds, String message) {
        for(Long userId:userIds) {
            Session session = sessionMap.get(userId);
            if (session != null&&session.isOpen()) {
                try {
                    session.getAsyncRemote().sendText(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
