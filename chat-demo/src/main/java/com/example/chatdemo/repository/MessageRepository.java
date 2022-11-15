package com.example.chatdemo.repository;

import com.example.chatdemo.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
}
