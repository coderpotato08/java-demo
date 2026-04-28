package com.example.springdemo.TeskAop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class TestSpringAop {

    public interface BusinessService {
        void doBusiness();
        Throwable throwError() throws Exception;
    }

    public static class BusinessServiceImpl implements BusinessService {
        @Override
        public void doBusiness() {
            System.out.println("执行业务逻辑");
        }
        @Override
        public Throwable throwError() throws Exception {
            throw new Exception("业务异常");
        }
    }

    // 定义前置通知
    public static class MyBeforeAdvice implements MethodBeforeAdvice {
        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("前置通知：在方法执行前记录日志");
        }
    }

    // 定义异常通知
    public static class MyThrowsAdvice implements ThrowsAdvice {
        public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
            System.out.println("异常通知：方法[" + method.getName() + "] 异常: " + ex.getMessage());
        }
    }
    public static void main(String[] args) throws Throwable {
        // 创建目标对象
        BusinessService target = new BusinessServiceImpl();
        // 创建相关通知对象
        MyBeforeAdvice advice = new MyBeforeAdvice();
        MyThrowsAdvice throwsAdvice = new MyThrowsAdvice();
        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置代理对象
        proxyFactory.setTarget(target);
        // 添加通知
        proxyFactory.addAdvice(advice);
        proxyFactory.addAdvice(throwsAdvice);
        // 获取代理对象
        BusinessService proxy = (BusinessService) proxyFactory.getProxy();
        // 调用代理对象的方法
        proxy.doBusiness();
        try {
            proxy.throwError();
        } catch (Exception ignored) {
        }
    }
}
