package com.example.springdemo.TestDemos.TestSynyacyicSugar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSyntacticSugar {
    public static void main(String[] args) {
        /* for-each */
        String[] str = {"Hollis", "公众号：Hollis", "博客：www.hollischuang.com"};
        for (String s : str) {
            System.out.println(s);
        }
        List<String> strList = new ArrayList<>();
        strList.add("Hollis");
        strList.add("公众号：Hollis");
        strList.add("博客：www.hollischuang.com");

        for (String s: strList) {
            System.out.println(s);
        }

        /* Lambda */
        strList.forEach( s -> { System.out.println(s); });

        /* try-with-resource */
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/a1234/Desktop/java/spring-demo/src/main/resources/static/user.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("file not exist");
        } finally {

        }
    }
}
