package com.example.chatdemo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.security.Principal;

@Controller
public class ExchangeEndpoint {

    Logger logger = LoggerFactory.getLogger("ExchangeEndpoint");
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private SimpUserRegistry simpUserRegistry;

    @MessageMapping("/exchange")
    @SendTo("/topic/messages")
    public String greeting(@Payload String msg, @Header("simpSessionId") String sessionId, Principal user){
        logger.info("User: {} Register: {} Message: {}", user.getName(), simpUserRegistry.getUserCount(), msg);
        return msg+" from Spring";
    }

    @SubscribeMapping("/hello")
    public String hello(){
        logger.info("Someone subs");
        return "Hello world";
    }


}
