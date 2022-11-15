package com.example.chatdemo.domain;


public record Message(
        Integer id,
        String author,
        String Message
) {
}