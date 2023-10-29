package com.corejava.threading;

class Dog implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Dog");
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }
}

class Cat implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Cat");
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }
}

public class ThreadingRunnable {
    public static void main(String[] args) {
        Dog obj1 = new Dog();
        Cat obj2 = new Cat();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        // add delay of 10 milli secs for avoiding clash b/w 2 threads
        try {
            Thread.sleep(10);
        } catch (Exception ignored) {
        }
        t2.start();
//        obj1.show();
//        obj2.show();
    }
}
/*
Dog
Cat
Dog
Cat
Dog
Cat
Dog
Cat
Dog
Cat
*/