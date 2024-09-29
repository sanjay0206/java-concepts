package com.corejava.threading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Runnable task = () -> System.out.println("Runnable task executed by: " + Thread.currentThread().getName());

        executor.submit(task);

        executor.shutdown();
    }
}
