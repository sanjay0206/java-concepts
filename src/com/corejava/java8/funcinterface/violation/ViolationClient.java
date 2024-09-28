package com.corejava.java8.funcinterface.violation;

public class ViolationClient {

    public static void main(String[] args) {

        // Using Anonymous class
        IDish burgerDish = new IDish() {

            @Override
            public void cook(String ingredients) {
                System.out.println("Cooking pasta with: " + ingredients);
            }

            @Override
            public void serve() {
                System.out.println("Dish is being served.");
            }
        };
        burgerDish.cook("WIth bun and patty");

        // Using lambda expressions
        /* Since we have two abstract methods our lambda does not know which method to invoke inside IDish interface
           This below code will cause error -> Multiple non-overriding abstract methods found in interface com.corejava.java8.funcinterface.violation.IDish
        */

        // IDish pastaDish = (ingredients) -> System.out.println("Cooking pasta with: " + ingredients);
       // pastaDish.cook("tomato sauce, garlic, olive oil");

    }
}
