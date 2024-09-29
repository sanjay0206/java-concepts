package com.corejava.java8.streams.coding.intsream;

import java.util.*;
import java.util.stream.IntStream;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 2, 5, 6, 4, 7};

        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        IntStream.of(numbers).forEach(num -> {
            if (!uniqueNumbers.add(num)) {
                duplicates.add(num);
            }
        });

        System.out.println("Duplicate numbers: " + duplicates);
    }
}
