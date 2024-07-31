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
        // Access values in sorted order
        for (Integer key : sortByKey) {
            System.out.println("Key: " + key + ", Value: " + unsortedMap.get(key));
        }

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
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue()));

    }
}

/*
sortByKey: [1, 2, 3, 4, 5, 6]
Key: 1, Value: Orange
Key: 2, Value: Banana
Key: 3, Value: Apple
Key: 4, Value: Mango
Key: 5, Value: Peach
Key: 6, Value: Grape
sortByValue: [Apple, Banana, Grape, Mango, Orange, Peach]
Sorted by key in asc order using Tree Map:::
1: Orange
2: Banana
3: Apple
4: Mango
5: Peach
6: Grape

Sorted by key in asc order:::
1=Orange
2=Banana
3=Apple
4=Mango
5=Peach
6=Grape

Sorted by key in desc order:::
6=Grape
5=Peach
4=Mango
3=Apple
2=Banana
1=Orange

Sorted by value in asc order:::
3=Apple
2=Banana
6=Grape
4=Mango
1=Orange
5=Peach

Sorted by value in dsc order:::
3=Apple
2=Banana
6=Grape
4=Mango
1=Orange
5=Peach
*/
