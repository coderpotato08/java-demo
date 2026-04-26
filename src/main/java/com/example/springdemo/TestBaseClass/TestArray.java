package com.example.springdemo.TestBaseClass;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class TestArray {
    public static void main(String[] args) throws InterruptedException {
        // Array
        /* 创建后长度固定，不能增删，通过下标修改值 */
        String[] strArr = new String[]{"a", "b", "c"};
        strArr[1] = "shit";
        System.out.println(Arrays.toString(strArr));

        // ArrayList 对象数组
        /* 用法1： 创建制定长度的数组 */
        ArrayList<String> arr = new ArrayList<>(3);
        arr.add("a");
        arr.add("b");
        arr.add("c");
        arr.add("d");
        System.out.println("Array length: " + arr.size());
        /* 用法2：在其他集合的基础上创建*/
        ArrayList<String> arr2 = new ArrayList<>(arr);
        arr2.add("hello");
        for(String s : arr2) {
            System.out.println(s);
        }

        // LinkedList 双向链表
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(1);

        // Arraylist (fail-fast) 示例：
        List<Integer> list = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println("Initial list: " + list);

        Thread t1 = new Thread(() -> {
            try {
                for (Integer i: list) {
                    System.out.println("Iterator Thread (t1) sees: " + i);
                    Thread.sleep(100);
                }
            } catch (ConcurrentModificationException e) {
                System.err.println("!!! Iterator Thread (t1) caught ConcurrentModificationException as expected.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(50);
                System.out.println("-> Modifier Thread (t2) is removing element 1...");
                list.remove(Integer.valueOf(1));
                System.out.println("-> Modifier Thread (t2) finished removal.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        t1.start();
        t2.start();
        latch.wait();

        System.out.println("Final list state: " + list);
    }
}
