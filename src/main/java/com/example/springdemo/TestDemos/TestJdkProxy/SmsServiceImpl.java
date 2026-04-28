package com.example.springdemo.TestDemos.TestJdkProxy;

public class SmsServiceImpl implements SmsSerivce {
    public String send (String smsCode) {
        System.out.println("send sms code: " + smsCode);
        return smsCode;
    }
}
