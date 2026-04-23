package com.example.springdemo.TestJdkProxy;

import java.lang.reflect.Proxy;
/*
* JDK Proxy实现代理
* 1. 创建Proxy 需要的 invocationHandler
* 2. JdkProxyFactory的静态方法getProxy 通过Proxy代理目标对象
* */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new SmsServiceInvocationHandler(target));
    }
}
