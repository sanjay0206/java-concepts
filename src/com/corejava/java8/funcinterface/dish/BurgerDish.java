package com.corejava.java8.funcinterface.dish;

public class BurgerDish implements IDish {
    private final String name;

    public BurgerDish(String name) {
        this.name = name;
    }

    // Implementing the abstract method
    @Override
    public void cook(String ingredients) {
        System.out.println("Cooking " + name + " with: " + ingredients);
    }

    // Overriding the toString method to provide meaningful output
    @Override
    public String toString() {
        return "Dish Name: " + name;
    }
}
