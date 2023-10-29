package com.corejava.threading;

class Hi extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }
}

class Hello extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
        }
    }
}

public class ThreadingDemo {
    public static void main(String[] args) {
        Hi obj1 = new Hi();
        Hello obj2 = new Hello();

        obj1.start();
        // add delay of 10 milli secs for avoiding clash b/w 2 threads
        try {
            Thread.sleep(10);
        } catch (Exception ignored) {
        }
        obj2.start();

//        obj1.show();
//        obj2.show();
    }
}
/*
Hi
Hello
Hi
Hello
Hi
Hello
Hi
Hello
Hi
Hello
*/