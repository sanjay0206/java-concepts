package com.corejava.collections.Maps.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapThread extends Thread {
    static ConcurrentHashMap<Integer, String> h = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        h.put(100, "X");
        h.put(101, "Y");
        h.put(102, "Z");
        ConcurrentHashMapThread t = new ConcurrentHashMapThread();
        t.start();
        for (Object o : h.entrySet()) {
            System.out.println(o);
            Thread.sleep(1000);
        }
        System.out.println(h);
    }

    public void run() {
        try {
            Thread.sleep(1000);
            // Child thread trying to add Objects
            // Adding new element in the object
            h.put(103, "D");
        } catch (InterruptedException e) {
            System.out.println("Child Thread will add objects");
        }
    }
}
