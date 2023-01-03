package com.googy.letterschatserver.kafka;

import com.googy.letterschatserver.domain.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.googy.letterschatserver.kafka.KafkaConstant.TOPIC_CHAT;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, ChatDto> kafkaTemplate;

    public void sendMessage(ChatDto chatDto) {
        this.kafkaTemplate.send(TOPIC_CHAT, chatDto);
    }
}
