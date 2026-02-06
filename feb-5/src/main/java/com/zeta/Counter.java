package com.zeta;

public class Counter {
    int count = 0;

    void increment() {
        System.out.println(count);
        synchronized (this) { //criticalsection
            count++;
        }
        for (; ; ) ;//continously working that's why deadlock

    }
         synchronized int getValue() {
            return count;
        }


}