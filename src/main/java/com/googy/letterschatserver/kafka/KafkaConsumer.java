package com.googy.letterschatserver.kafka;

import com.googy.letterschatserver.domain.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.googy.letterschatserver.kafka.KafkaConstant.GROUP_ID;
import static com.googy.letterschatserver.kafka.KafkaConstant.TOPIC_CHAT;

@Service
public class KafkaConsumer {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics = TOPIC_CHAT, groupId = GROUP_ID)
    public void consumer(ChatDto chatDto) throws IOException {
        simpMessagingTemplate.convertAndSend("/sub/chat/" + chatDto.getChannel(), chatDto);
    }
}
