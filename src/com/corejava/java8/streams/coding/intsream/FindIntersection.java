package com.corejava.java8.streams.coding.intsream;

import java.util.*;
import java.util.stream.IntStream;

public class FindIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};

        Set<Integer> set1 = new HashSet<>();
        IntStream.of(arr1).forEach(set1::add);

        Set<Integer> intersection = new HashSet<>();
        IntStream.of(arr2).filter(set1::contains).forEach(intersection::add);

        System.out.println("Intersection of arrays: " + intersection);
    }
}
