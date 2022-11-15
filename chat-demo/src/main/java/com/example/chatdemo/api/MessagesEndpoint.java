package com.example.chatdemo.api;

import com.example.chatdemo.domain.Message;
import com.example.chatdemo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/messages")
public class MessagesEndpoint {
    private final MessageService messageService;
    Logger logger = LoggerFactory.getLogger("Messages");

    public MessagesEndpoint(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Iterable<Message> gettAll(){
        logger.info("Request about msgs");
        return messageService.getMessages();
    }
}
