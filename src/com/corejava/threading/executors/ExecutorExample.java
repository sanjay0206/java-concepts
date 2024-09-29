package com.corejava.threading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Create a thread pool of 2 threads

        // Submit two tasks for execution NOTE: All submitted tasks are Runnable.
        executor.submit(() -> System.out.println("Task 1 executed by: " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 2 executed by: " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 3 executed by: " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("Task 4 executed by: " + Thread.currentThread().getName()));

        executor.shutdown(); // Shut down the executor else program will not stop

    }
}
