package com.corejava.java8.streams.coding.intsream;

import java.util.stream.IntStream;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5, 6};  // Missing number is 3
        int n = 6;

        int actualSum = IntStream.of(numbers).sum();
        int expectedSum = IntStream.rangeClosed(1, n).sum();

        int missingNumber = expectedSum - actualSum;
        System.out.println("Missing number: " + missingNumber);
    }
}
