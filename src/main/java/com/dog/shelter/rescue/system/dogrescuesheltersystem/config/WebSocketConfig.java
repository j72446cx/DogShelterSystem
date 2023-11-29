package com.dog.shelter.rescue.system.dogrescuesheltersystem.config;

import com.dog.shelter.rescue.system.dogrescuesheltersystem.domain.WebSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.server.ServerEndpoint;

@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig{

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Bean
    public ServletContextListener servletContextListener() {
        return new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                WebSocket.setApplicationContext(WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()));
            }
        };
    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/websocket").withSockJS();
//    }
}
