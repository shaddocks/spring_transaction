package edu.study.book.chapter8.queuefile;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        test03();
    }

    public static void test01(){
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.offer(10);
        priorityQueue.offer(7);
        priorityQueue.offer(15);
        priorityQueue.offer(5);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());
    }

    public static void test02(){
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("11");
        stack.push("12");
        stack.push("13");
        stack.push("14");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    public static void test03(){
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("11");
        queue.offer("12");
        queue.offer("13");
        queue.offer("14");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
