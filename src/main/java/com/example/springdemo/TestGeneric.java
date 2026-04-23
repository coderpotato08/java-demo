package com.example.springdemo;

import java.util.ArrayList;
import java.util.List;

class Cell {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Human extends Cell {
    public void printLog() {
        System.out.println("Hello, l am a cell");
    }
}
class Tom extends Human {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
public class TestGeneric {
    public static void main(String[] args) {
        Integer[] integerArray = { 1, 2 };
        String[] stringArray = { "Hello", "world" };
        printArray(integerArray);
        printArray(stringArray);

        /* 上边界通配符 */
        Cell cell = new Cell();
        Human human = new Human();
        Tom tom = new Tom();
        /* PECS 原则（Producer Extends, Consumer Super）*/
        /* 从数据结构取元素时用 extends（生产者，Producer）；向数据结构写元素时用 super（消费者，Consumer）*/
        List<? super Human> cellOrHumanList = new ArrayList<>();
        cellOrHumanList.add(human);
        cellOrHumanList.add(tom);
        Object humanGet = cellOrHumanList.get(0);

        List<? extends Human> tomOrHumanList = new ArrayList<>();
        Human a = tomOrHumanList.get(0);
    }

    public static < T > void printArray( T[] inputArray ) {
        for ( T element: inputArray ) {
            System.out.println(element);
        }
    }
}
