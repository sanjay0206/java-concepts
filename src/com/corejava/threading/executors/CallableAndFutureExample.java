package com.corejava.threading.executors;

import java.util.concurrent.*;

public class CallableAndFutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> pizzaOrder = executor.submit(() -> {
            Thread.sleep(3000); // Simulate time taken to prepare the pizza
            return "Pizza is ready!";
        });

        // Do other tasks while the pizza is being prepared
        System.out.println("Waiting for pizza...");
        try {
            String result = pizzaOrder.get(); // Blocking call
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

/*
-> Main Thread: Always runs and may continue doing work or wait depending on how Future is handled.
-> New Thread (Runnable or Callable): Executes the given task concurrently with the main thread.
-> If you use future.get(), the main thread waits until the task completes, but without calling get(), both threads can continue independently.

*/