package com.example.springdemo.TestDemos.TestCollecntion;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        System.out.println("queue: " + queue.toString());
        boolean a = queue.offer("e");
        // add()、offer() 插入队尾
        System.out.println("tail in -> queue: " + queue.toString() + "  " + a);
        // remove()	poll() 删除队首
        String head = queue.remove();
        System.out.println("head out -> queue: " + queue.toString() + "  " + head);
        head = queue.poll();
        System.out.println("head out -> queue: " + queue.toString() + "  " + head);
        queue.poll();
        queue.poll();
        queue.poll();
        // element() peek()
        String e = queue.peek();
        System.out.println("head is: " + e);
        // add() remove() element() 会抛错
//        String e2 = queue.element();

        // BlockingQueue 阻塞队列 队列为空时调用出队 或 队列为满时入队会抛错
        try {
            BlockingQueue<String> blockQueue = new ArrayBlockingQueue<>(3);
            blockQueue.add("1");
            blockQueue.add("1");
            blockQueue.add("1");
            blockQueue.add("1");
        } catch (IllegalStateException err) {
            if (err.getMessage().equals("Queue full")) {
                System.out.println("队列已满 已阻塞");
            }
        }
    }
}
