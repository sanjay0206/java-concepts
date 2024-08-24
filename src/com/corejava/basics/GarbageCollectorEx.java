package com.corejava.basics;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectorEx {

    /*
    -> Automatic Memory Management
    -> Prevents Memory Leaks
    -> Improves Reliability
    -> Optimizes Performance
     */

    public static void main(String[] args) {
        // Creating a list of objects
        List<String> list = new ArrayList<>();

        // Adding objects to the list
        for (int i = 0; i < 10; i++) {
            list.add("Item " + i);
        }

        // Printing the list to show its contents
        System.out.println("List before setting to null:");
        for (String item : list) {
            System.out.println(item);
        }

        // Clearing the reference to the list
        list = null;

        // Requesting garbage collection (not guaranteed to run immediately)
        System.gc();

        // Optionally, adding a small delay to ensure GC has time to run
        try {
            Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // At this point, the list should be eligible for garbage collection
        // You won't typically see this reflected in your code, but you can verify using tools like JVisualVM or JConsole
    }

}
