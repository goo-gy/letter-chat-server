package com.googy.letterschatserver.domain;
import lombok.*;

@Data
public class ChatDto {
    private String channel;
    private String sender;
    private String message;
}
