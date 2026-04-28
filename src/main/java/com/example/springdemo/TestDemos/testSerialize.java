package com.example.springdemo.TestDemos;

import com.example.springdemo.common.User;

import java.io.*;

public class testSerialize {
    public static void main(String[] args) {
        User user = new User("smile", 12);

        try {
            ObjectOutputStream objInputStream = new ObjectOutputStream(new FileOutputStream("/Users/a1234/Desktop/java/spring-demo/src/main/resources/static/user.txt"));
            objInputStream.writeObject(user);
            objInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("/Users/a1234/Desktop/java/spring-demo/src/main/resources/static/user.txt"));
            try {
                Object object = objInputStream.readObject();
                User use = (User) object;
                System.out.println(user.getName() + user.getAge());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
