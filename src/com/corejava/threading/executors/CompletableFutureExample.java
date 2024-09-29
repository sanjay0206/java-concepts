package com.corejava.threading.executors;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Step 1: Prepare the pizza asynchronously
        CompletableFuture<String> pizzaOrder = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Preparing the pizza...");
                Thread.sleep(3000); // Simulate time taken to prepare the pizza
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Pizza is ready!";
        });

        // Step 2: Prepare drinks asynchronously
        CompletableFuture<String> drinksOrder = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Preparing the drinks...");
                Thread.sleep(2000); // Simulate time taken to prepare drinks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Drinks are ready!";
        });

        // Step 3: Combine results and notify the customer
        CompletableFuture<Void> orderComplete = CompletableFuture.allOf(pizzaOrder, drinksOrder)
                .thenRun(() -> {
                    String pizzaResult;
                    String drinksResult;
                    try {
                        pizzaResult = pizzaOrder.get();  // Get pizza result
                        drinksResult = drinksOrder.get(); // Get drinks result
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(pizzaResult);
                    System.out.println(drinksResult);
                    System.out.println("Customer notified: Your order is complete!");
                });

        // Keep main thread alive long enough to see the results
        try {
            orderComplete.get(); // Block until the order is complete
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
