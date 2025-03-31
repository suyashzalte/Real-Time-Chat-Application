package com.chat.chatApp.controller;

import com.chat.chatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage")//IF ANY ONE WANT TO HIT THE MESSAGE TO  ("/sendMessage") IT WILL HIT TO THE (/app/sendMessage)AND THEN WILL MOVE FORWARD TO ("/topic/message")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage message)
    {

        return message;
    }

    @GetMapping("/chat")
    public String chat()
    {
        return "chat";
    }
}
