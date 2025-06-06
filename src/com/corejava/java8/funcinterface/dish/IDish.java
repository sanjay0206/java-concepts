package com.corejava.java8.funcinterface.dish;

@FunctionalInterface
interface IDish {
    // Static method
    static void info() {
        System.out.println("This is info method from Dish.");
    }

    // Default method
    default void serve() {
        System.out.println("Dish is being served.");
    }

    // Overriding Object class method is allowed
    String toString(); // Overriding the toString method from Object class

    // Abstract method
    void cook(String ingredients);

    // Second abstract method (this violates @FunctionalInterface)
//    void prepare();
}
