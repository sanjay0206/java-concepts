package com.corejava.threading.lambda;

public class ThreadLambda {
    public static void main(String[] args) throws InterruptedException {
        Thread task1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Bike-t1");
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {}
            }
        });

        Runnable bikeTask = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Bike-t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        };

        task1.start();

        Thread task2 = new Thread(bikeTask);
        task2.start();

//        task1.join();
//        task2.join();

    }
}
/*
Bike-t1
Bike-t2
Bike-t2
Bike-t1
Bike-t2
Bike-t1
Bike-t2
Bike-t1
Bike-t1
Bike-t2
*/