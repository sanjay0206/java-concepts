package com.corejava.collections.Maps;

import java.util.*;
import java.util.stream.Collectors;

public class MapSorting {

    public static void main(String[] args) {
        Map<Integer, String> unsortedMap = new HashMap<>();
        unsortedMap.put(3, "Apple");
        unsortedMap.put(1, "Orange");
        unsortedMap.put(2, "Banana");
        unsortedMap.put(6, "Grape");
        unsortedMap.put(5, "Peach");
        unsortedMap.put(4, "Mango");

        List<Integer> sortByKey = new ArrayList<>(unsortedMap.keySet());
        Collections.sort(sortByKey);
        System.out.println("sortByKey: " + sortByKey);

        List<String> sortByValue = new ArrayList<>(unsortedMap.values());
        Collections.sort(sortByValue);
        System.out.println("sortByValue: " + sortByValue);

        Map<Integer, String> sortedMap = new TreeMap<>(unsortedMap);
        System.out.println("Sorted by key in asc order using Tree Map:::");
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // sort by key
       /* LinkedHashMap<Integer, String>  map = unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));*/

        System.out.println("Sorted by key in asc order:::");
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("Sorted by key in desc order:::");
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(System.out::println);

        // sort by value
        System.out.println("Sorted by value in asc order:::");
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        System.out.println("Sorted by value in dsc order:::");
        unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

    }
}
