package com.corejava.java8.funcinterface;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceEx {

    public static void main(String[] args) {

        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Goa", "Pune");

        // Using Consumer and andThen
        Consumer<String> convertToUppercase = name -> System.out.println("Converted name: " + name.toUpperCase());
        Consumer<String> convertToLowercase = name -> System.out.println("Converted name: " + name.toLowerCase());
        convertToUppercase.andThen(convertToLowercase).accept("chennai");   // Chaining consumers

        // Using Predicate
        Predicate<String> filteredCities = city -> city.equals("Mumbai") || city.equals("Goa");
        Predicate<String> startsWithG = city -> city.startsWith("G");
        System.out.println("Filtered Cities:");
        cities.stream()
                .filter(filteredCities.and(startsWithG)) // Combining predicates
                .forEach(System.out::println);

        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Output: true
        System.out.println(isEven.test(7)); // Output: false

        // Using Function and andThen
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer, Integer> squareFunction = num -> num * num;
        Function<Integer, String> squareToStringFunction = num -> "Square: " + num;
        System.out.println("Squared Numbers:");
        numbers.stream()
                .map(squareFunction.andThen(squareToStringFunction)) // Chaining functions
                .forEach(result -> System.out.print(result + " "));

        // Using Supplier
        Supplier<Double> randomNumberSupplier = Math::random;
        System.out.println("\nRandom Number: " + randomNumberSupplier.get());
    }
}
