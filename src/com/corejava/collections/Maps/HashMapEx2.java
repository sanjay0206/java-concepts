package com.corejava.collections.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<String, Integer> fruitsMap = new HashMap<>();

        // Add fruit names and their lengths to the TreeMap
        fruitsMap.put("Apple", "Apple".length());
        fruitsMap.put("Orange", "Orange".length());
        fruitsMap.put("Banana", "Banana".length());
        fruitsMap.put("Grape", "Grape".length());
        fruitsMap.put("Peach", "Peach".length());
        fruitsMap.put("Mango", "Mango".length());
        System.out.println(fruitsMap);

        fruitsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        int targetValue = 6;
        List<String> list = new ArrayList<>();
        fruitsMap.entrySet().stream()
                .filter(entry -> entry.getValue() == targetValue)
                .forEach(entry -> list.add(entry.getKey()));

        // Print the keys where the value is equal to 6
        System.out.println("Keys with string length " + targetValue + ": " + list);

    }

}

/*
{Apple=5, Grape=5, Peach=5, Mango=5, Orange=6, Banana=6}
Apple=5
Grape=5
Peach=5
Mango=5
Orange=6
Banana=6
Keys with string length 6: [Orange, Banana]
*/
