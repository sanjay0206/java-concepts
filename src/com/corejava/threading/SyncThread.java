package com.corejava.threading;

class Counter {
    int count;

    // maximum only one thread can use this at a time
    // So if your method is not synchronized, then your method is not thread safe
    public synchronized void increment() {
        count++; // count = count + 1 -> Action 1: addition, Action 2: assignment
    }
}

public class SyncThread {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
//        c.increment();
//        c.increment();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        // t1.join(); asking Main thread to wait until t1 completes its job
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count: " + c.count); // Count: 2000
    }
}
