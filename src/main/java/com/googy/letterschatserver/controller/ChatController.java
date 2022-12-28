package com.googy.letterschatserver.controller;

import com.googy.letterschatserver.domain.ChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat") // /pub/chat
    public void publishChat(ChatDto chatDto) {
        simpMessagingTemplate.convertAndSend("/sub/chat/" + chatDto.getChannel(), chatDto);
    }
}
