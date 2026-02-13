package com.zeta;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
