package com.corejava.java8.streams.coding;

import java.util.*;
import java.util.stream.Collectors;

public class ListStreamEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list);

        int evenSum = list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(evenSum);

        int oddSum = list.stream()
                .filter(x -> x % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(oddSum);

        Map<String, Integer> people = new HashMap<>();
        people.put("John", 25);
        people.put("Alice", 30);
        people.put("Bob", 22);
        people.put("Diana", 30);
        people.forEach((k, v) -> System.out.println(k + ": " + v));

        int maxAge = people.values().stream()
                .mapToInt(age -> age)
                .max()
                .orElse(0);
        System.out.println("Max age: " + maxAge);

        people.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxAge))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
