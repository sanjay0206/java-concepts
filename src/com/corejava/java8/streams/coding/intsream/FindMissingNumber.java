package com.corejava.java8.streams.coding.intsream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5, 6};  // Missing number is 3
        int n = numbers.length + 1;

        int actualSum = IntStream.of(numbers).sum();
        int expectedSum = IntStream.rangeClosed(1, n).sum();
//        int expectedSum = n * (n + 1 ) / 2 ;

        System.out.println(actualSum);
        System.out.println(expectedSum);

        int missingNumber = expectedSum - actualSum;
        System.out.println("Missing number: " + missingNumber);


        // 5,1,6,2
        // 1 2 5 6
        List<Integer> list = Arrays.asList(5, 1, 6, 2);
        List<Integer> missingNumbers = IntStream.rangeClosed(1, list.size())
                .boxed()
                .filter(x -> !list.contains(x))
                .collect(Collectors.toList());
        System.out.println(missingNumbers);
    }
}
