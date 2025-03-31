package com.chat.chatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
       registry.addEndpoint("/chat")//DEFINE AN ENDPOINT. It must be (localhost://8080/chat)
               .setAllowedOrigins("http://localhost:8080").withSockJS();//entertain from these url or we will work with these link

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");//messageBroker handle the message and broadcast
        registry.setApplicationDestinationPrefixes("/app");//telling server if any message comes from "/app" just process it
        //set message broker
        //expect message with /api /send message
    }
}
