package com.example.springdemo.TestDemos.TestCglibProxy;

public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}