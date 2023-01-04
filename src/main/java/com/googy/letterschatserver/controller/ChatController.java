package com.googy.letterschatserver.controller;

import com.googy.letterschatserver.domain.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat") // /pub/chat
    public void publishChat(ChatDto chatDto) {
        simpMessagingTemplate.convertAndSend("/sub/chat/" + chatDto.getChannel(), chatDto);
    }
}
