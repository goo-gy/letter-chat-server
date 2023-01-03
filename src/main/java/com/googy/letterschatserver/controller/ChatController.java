package com.googy.letterschatserver.controller;

import com.googy.letterschatserver.domain.ChatDto;
import com.googy.letterschatserver.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    private KafkaProducer producer;

    @MessageMapping("/chat") // /pub/chat
    public void publishChat(ChatDto chatDto) {
        producer.sendMessage(chatDto);
    }
}
