package com.example.springdemo.TestJdkProxy;

public class SmsServiceImpl implements SmsSerivce {
    public String send (String smsCode) {
        System.out.println("send sms code: " + smsCode);
        return smsCode;
    }
}
