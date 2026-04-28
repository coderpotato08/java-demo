package com.example.springdemo.TestDemos.TestCollecntion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Comparable 需要实现compareTo的接口，对比两个值的大小
class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    // ...Getter and Setter

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        }
        if (this.age < o.getAge()) {
            return -1;
        }
        return 0;
    }
}

public class TestComparatorAndComparable {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        // Comparator 实现定制排序方法
        //  Collections.sort默认从小到大排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):" + arrayList.toString());
        // Collections.sort第二个参数 Comparator
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("Collections.sort(arrayList):" + arrayList.toString());


    }
}
