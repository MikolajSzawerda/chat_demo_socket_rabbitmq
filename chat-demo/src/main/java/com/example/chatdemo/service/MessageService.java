package com.example.chatdemo.service;


import com.example.chatdemo.domain.Message;
import com.example.chatdemo.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Iterable<Message> getMessages(){
        return messageRepository.findAll();
    }
}
