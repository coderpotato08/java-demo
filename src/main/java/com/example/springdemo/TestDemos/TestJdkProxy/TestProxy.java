package com.example.springdemo.TestDemos.TestJdkProxy;

public class TestProxy {
    public static void main(String[] args) {
        SmsSerivce smsService = (SmsSerivce) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("123123");
    }
}
