package com.corejava.threading;

public class ThreadPriorityAndLambda {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Bike-t1");
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Bike-t2");
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }
        });

        t1.setName("Bike Thread-1");
        t2.setName("Bike Thread-2");
        System.out.println(t1.getName());
        System.out.println(t2.getName());

      /*  1. MIN_PRIORITY = 1
        2. NORM_PRIORITY = 5
        3. MAX_PRIORTY = 10*/
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.setPriority(Thread.MIN_PRIORITY);
        System.out.println(t1.getPriority());


        t1.start();
        // add delay of 10 milli secs for avoiding clash b/w 2 threads
        try {
            Thread.sleep(10);
        } catch (Exception ignored) {
        }
        t2.start();

        // So the meaning of "join" is t1 and t2 will join back main thread after
        // they finish their own thread. So main thread has to wait for their join

        System.out.println(t1.isAlive());
        t1.join();
        t2.join();
        System.out.println(t1.isAlive());
        System.out.println("Bye");
    }
}
/*
Bike Thread-1
Bike Thread-2
5
5
1
Bike-t1
true
Bike-t2
Bike-t1
Bike-t2
Bike-t1
Bike-t2
Bike-t1
Bike-t2
Bike-t1
Bike-t2
false
By
*/