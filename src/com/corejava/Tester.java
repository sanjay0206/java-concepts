package com.corejava;

import java.util.*;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {

        HashMap<String, Integer> fruitsMap = new HashMap<>();

        // Add fruit names and their lengths to the TreeMap
        fruitsMap.put("Apple", "Apple".length());
        fruitsMap.put("Orange", "Orange".length());
        fruitsMap.put("Banana", "Banana".length());
        fruitsMap.put("Grape", "Grape".length());
        fruitsMap.put("Peach", "Peach".length());
        fruitsMap.put("Mango", "Mango".length());

        fruitsMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        fruitsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);


        int targetValue = 6;
        List<String> list = new ArrayList<>();
        fruitsMap.entrySet().stream()
                .filter(entry -> entry.getValue() == targetValue)
                .forEach(entry -> list.add(entry.getKey()));

        // Print the keys where the value is equal to 5
        System.out.println("Keys with string length " + targetValue + ": " + list);

    }
}
