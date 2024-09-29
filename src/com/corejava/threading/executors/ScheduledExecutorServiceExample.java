package com.corejava.threading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        // Create a ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Task to simulate placing a pizza order
        Runnable placeOrderTask = () -> System.out.println("Pizza order placed!");

        // Schedule the order placement to run after a 5-second delay
        scheduler.schedule(placeOrderTask, 5, TimeUnit.SECONDS);

        // Task to check the order status every 2 seconds
        Runnable checkOrderStatusTask = () -> System.out.println("Checking order status...");

        // Schedule the status check task with an initial delay of 0 seconds and repeat every 2 seconds
        scheduler.scheduleAtFixedRate(checkOrderStatusTask, 0, 2, TimeUnit.SECONDS);

        // Allow the tasks to run for 15 seconds
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shut down the scheduler
        scheduler.shutdown();
        System.out.println("Scheduler shut down.");
    }
}
