package com.example.chatdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
public class STOMPConfig {
//    @Bean
//    SimpMessagingTemplate simpMessagingTemplate(){
//        return new SimpMessagingTemplate(new SubscribableChannel() {
//            @Override
//            public boolean subscribe(MessageHandler handler) {
//                return false;
//            }
//
//            @Override
//            public boolean unsubscribe(MessageHandler handler) {
//                return false;
//            }
//
//            @Override
//            public boolean send(Message<?> message, long timeout) {
//                return false;
//            }
//        });
//    }
}
