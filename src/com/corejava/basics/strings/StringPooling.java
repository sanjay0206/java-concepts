package com.corejava.basics.strings;

public class StringPooling {

    public static void main(String[] args) {
        String name = "John";
        String anotherName = "John";

        String aThirdName = new String("John");
        System.out.println(name == anotherName); // true
        System.out.println(name == aThirdName); // false

        /* String objects are immutable, meaning they cannot be changed after they are created.
         Because of their immutability, they are inherently thread-safe. This implies that multiple threads
         can operate on String objects without the risk of unexpected behavior or data corruption. */
        String greeting = "Hello"; // A string is created

        // Multiple threads accessing the same string
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(greeting); // No synchronization is needed
            }
        };

        // Creating multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        // Starting the threads
        thread1.start();
        thread2.start();
    }
}
/*
true
false
Hello
Hello
Hello
Hello
Hello
Hello
*/