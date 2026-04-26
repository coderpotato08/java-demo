package com.example.springdemo.TestBigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimal {
    public static void main(String[] args) {
        // 小数的数精度都问题
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false

        System.out.println("--------------------");

        // BigDecimal
        BigDecimal aa = new BigDecimal("1.0");
        BigDecimal bb = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = aa.subtract(bb);
        BigDecimal y = bb.subtract(c);

        System.out.println(x.compareTo(y));// 0

        System.out.println("--------------------");

        // BigDecimal divide
        // 为了防止精度丢失，推荐使用它的BigDecimal(String val)构造方法或者 BigDecimal.valueOf(double val) 静态方法来创建对象
        BigDecimal d1 = new BigDecimal("17");
        BigDecimal d2 = BigDecimal.valueOf(3.86f);
        System.out.println("d1 = " + d1 + ";" + "d2 = " + d2);
        System.out.println(d1.divide(d2, 5, RoundingMode.HALF_UP));


    }
}
