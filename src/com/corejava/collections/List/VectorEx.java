package com.corejava.collections.List;

import java.util.Vector;

public class VectorEx {

    public static void main(String[] args) {

        Vector<String> gadgets = new Vector<>();

        gadgets.add("Smartphone");
        gadgets.add("Laptop");
        gadgets.add("Smartwatch");
        gadgets.add("Tablet");
        gadgets.add("Headphones");

        System.out.println("Original Vector: " + gadgets);

        // Access an element by index
        String thirdGadget = gadgets.get(2); // Index is zero-based
        System.out.println("The third gadget is: " + thirdGadget);

        // Modify an element
        gadgets.set(1, "Gaming Laptop"); // Replace "Laptop" with "Gaming Laptop"
        System.out.println("Vector after modification: " + gadgets);

        // Insert an element at a specific position
        gadgets.insertElementAt("Smart Glasses", 2); // Insert at index 2
        System.out.println("Vector after insertion: " + gadgets);

        // Remove an element
        gadgets.remove("Headphones");
        System.out.println("Vector after removal: " + gadgets);

        // Iterate over the Vector
        System.out.println("Iterating over the Vector:");
        for (String gadget : gadgets) {
            System.out.println("- " + gadget);
        }

        // Check if the Vector contains a specific element
        boolean hasSmartwatch = gadgets.contains("Smartwatch");
        System.out.println("Does the Vector contain Smartwatch? " + hasSmartwatch);
    }
}
