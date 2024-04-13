package com.corejava.java8.funcinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceEx {
    // Consumer
    @Test
    public void printCities() {

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        // Using a Consumer to convert names to uppercase
        Consumer<String> convertToUppercase = name -> System.out.println("Converted name: " + name.toUpperCase());

        // Applying the Consumer to each name
        cities.forEach(convertToUppercase);

        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello"); //  HELLO

      /*  Converted name: DELHI
          Converted name: MUMBAI
          Converted name: GOA
          Converted name: PUNE
       */
    }

    // Predicate
    @Test
    public void filterCities() {

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        Predicate<String> filterCity = city -> city.equals("Mmbai");
        cities.stream()
                .filter(filterCity)
                .forEach(System.out::println); // Mumbai

        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Output: true
        System.out.println(isEven.test(7)); // Output: false
    }

    // Function
    @Test
    public void mapCities() {

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        Function<String, Character> getFirstCharFunction = city -> city.charAt(0);
        cities.stream()
                .map(getFirstCharFunction)
                .forEach(System.out::println);

        /* D
           M
           G
           P
        */

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer, Integer> squareFunction = num -> num * num;
        numbers.stream()
                .map(squareFunction)
                .forEach(result -> System.out.print(result + " "));

        // 1 4 9 16 25
    }

    // Supplier
    @Test
    public void supplyCities() {

        Supplier<Double> randomNumberSupplier = Math::random;
        System.out.println(randomNumberSupplier.get()); // 0.017852732689994877

        Supplier<String> greetingsSupplier = () -> {
            String[] greetings = {"Hello", "Bonjour", "Hola", "Namaste"};
            int randomIndex =  (((int) (Math.random() * 10)) % greetings.length );
            return greetings[randomIndex];
        };
        System.out.println(greetingsSupplier.get()); // Namaste
    }
}
