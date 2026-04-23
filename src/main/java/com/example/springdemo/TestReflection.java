package com.example.springdemo;

import com.example.springdemo.common.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}

public class TestReflection {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /*
         * 获取 TargetObject 类的 Class 对象并且创建 TargetObject 类实例
         */
        Class<?> targetClass = Class.forName("com.example.springdemo.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();
        /*
        * 获取 TargetObject 类中定义的所有方法
        * */
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
        }

        /*
        * 获取指定方法并调用
        * */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "JavaGuide");

        /*
        * 获取指定参数并对参数进行修改
        * */
        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "JavaDemo");

        /*
        * 调用 private 方法
        * */
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
