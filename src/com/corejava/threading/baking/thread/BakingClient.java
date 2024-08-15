package com.corejava.threading.baking.thread;

class Dessert {
    public void serve(String dessertName) {
        System.out.println("Serving " + dessertName + "with id: " + Thread.currentThread().getId());
    }
}

// Here since multiple inheritance is not support we can't extend Dessert so not able to use server().
class Cake extends Thread {
    public void run() {
        System.out.println("Mixing Ingredients for Cake with id: " + Cake.currentThread().getId());
        System.out.println("Baking Cake with id: " + Cake.currentThread().getId());
        System.out.println("Decorating Cake with id: " + Cake.currentThread().getId());
    }
}

// So to extend a class we implement Runnable to make use of thread.
class Brownie extends Dessert implements Runnable {
    @Override
    public void run() {
        System.out.println("Mixing Ingredients for Brownie with id: " + Thread.currentThread().getId());
        System.out.println("Baking Brownie with id: " + Thread.currentThread().getId());
        System.out.println("Decorating Brownie with id: " + Thread.currentThread().getId());
        serve("Brownie");
    }
}

class BakingClient {
    public static void main(String[] args) {

        int cakeCount = 3;

        for (int i = 1; i <= cakeCount; i++) {
         /*
           // Using extends Thread
            Cake cake = new Cake();
           cake.run();   // Will not do process processing and print in order
           cake.start(); // Will do parallel processing
        */

            // Using implements Runnable
            Brownie brownie = new Brownie();
            Thread brownieThread = new Thread(brownie);
            brownieThread.setName("Brownie_" + brownieThread.getId());

            // Suppose if a customer want urgent delivery with extra amount paid we can prioritize that task ex) 3rd Brownie
            if (i == 3) {
                brownieThread.setPriority(Thread.MAX_PRIORITY);
            }

            System.out.println(brownieThread.getName() + " has priority: " + brownieThread.getPriority());
            // Start the thread
            brownieThread.start();

            try {
             //   brownieThread.join(); // will not adhere to parallel processing
                Thread.sleep(1000); // will not affect parallel process but will affect execution of thread
            } catch (InterruptedException ignored) {}

        }

        // To check whether the thread is alive or not?
        Cake chocoCake = new Cake();
        chocoCake.setName("ChocoCake_" + chocoCake.getId());
        System.out.println(chocoCake.getName() + " isAlive " + chocoCake.isAlive());

        // start chocoCake thread
        chocoCake.start();

        System.out.println(chocoCake.getName() + " isAlive " + chocoCake.isAlive());
    }
}

/*
Brownie_12 has priority: 5
Mixing Ingredients for Brownie with id: 12
Baking Brownie with id: 12
Decorating Brownie with id: 12
Serving Browniewith id: 12

Brownie_13 has priority: 5
Mixing Ingredients for Brownie with id: 13
Baking Brownie with id: 13
Decorating Brownie with id: 13
Serving Browniewith id: 13

Brownie_14 has priority: 10
Mixing Ingredients for Brownie with id: 14
Baking Brownie with id: 14
Decorating Brownie with id: 14
Serving Browniewith id: 14

ChocoCake_15 isAlive false
ChocoCake_15 isAlive true
Mixing Ingredients for Cake with id: 15
Baking Cake with id: 15
Decorating Cake with id: 15


Process finished with exit code 0
*/