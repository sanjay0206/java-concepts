package com.corejava.basics.oops.polymorphism;

public class CompiletimeMathOperations {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two double values
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        CompiletimeMathOperations math = new CompiletimeMathOperations();

        System.out.println(math.add(2, 3));        // Output: 5
        System.out.println(math.add(2, 3, 4));     // Output: 9
        System.out.println(math.add(2.5, 3.5));    // Output: 6.0
    }
}

/*
-> The MathOperations class has three overloaded methods named add.
-> Each method has a different signature (different parameter types or different number of parameters).
-> In the Main class, we call these overloaded methods with different sets of arguments.
-> The method that gets executed is determined at compile-time based on the argument types and count.
-> This is compile-time polymorphism in action.
*/