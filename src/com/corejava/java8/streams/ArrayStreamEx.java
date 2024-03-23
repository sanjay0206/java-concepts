package com.corejava.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ArrayStreamEx {
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
    }
}
