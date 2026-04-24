package com.example.springdemo.TestBaseClass;

public class TestString {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";

        /* String 与 StringBuilder 字符串拼接效率对比*/
        String strResult = "";
        StringBuilder sbResult = new StringBuilder();
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            strResult += "a";
        }
        long time1 = System.currentTimeMillis() - startTime1;

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sbResult.append("a");
        }
        long time2 = System.currentTimeMillis() - startTime2;
        System.out.println("String 拼接耗时: " + time1 + " ms");
        System.out.println("StringBuilder拼接耗时: " + time2 + " ms");

    }
}
