package com.corejava.java8.funcinterface.dish;


public class DishClient {

    public static void main(String[] args) {

        // Using a lambda to implement the single abstract method 'cook' in the functional interface 'Dish'
        IDish pastaDish = (ingredients) -> System.out.println("Cooking pasta with: " + ingredients);

        // Calling the abstract method via lambda
        pastaDish.cook("tomato sauce, garlic, olive oil");

        // Calling the default method
        pastaDish.serve();

        // Calling the static method
        IDish.info();

        // Calling the overridden toString method
        BurgerDish burgerDish = new BurgerDish("Burger");
        System.out.println(burgerDish);
    }
}

/*
Cooking pasta with: tomato sauce, garlic, olive oil
Dish is being served.
This is info method from Dish.
Dish Name: Burger
*/
