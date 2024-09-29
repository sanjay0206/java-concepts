package com.corejava.java8.streams.coding.intsream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamEx {

    public static boolean isPrime(int n) {
        return IntStream.range(2, (int) Math.sqrt(n) + 1)
                .noneMatch(i ->  n % i == 0);
    }

    public static void main(String[] args) {
        int sum = IntStream.range(1, 101).sum();
        System.out.println("Sum of numbers from 1 to 100: " + sum);

        int[] numbers = {3, 5, 7, 2, -8, 1};
        int max = IntStream.of(numbers).max().orElse(0);
        int min = IntStream.of(numbers).min().orElse(0);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        List<Integer> integerList = IntStream.of(numbers)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("List of Integers: " + integerList);

        IntStream.rangeClosed(1, 20)
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

        int sumOfSquares = IntStream.rangeClosed(1, 5)
                .map(num -> num * num)
                .sum();
        System.out.println("Sum of squares from 1 to 5: " + sumOfSquares);

        boolean allPositive = IntStream.of(numbers).allMatch(num -> num > 0);
        System.out.println("Are all numbers positive? " + allPositive);

        int product = IntStream.range(1, 6)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of numbers from 1 to 5: " + product);

        IntStream.rangeClosed(2,30)
                .filter(IntStreamEx::isPrime)
                .forEach(System.out::println);

        long oddCount = IntStream.of(numbers)
                .filter(num -> num % 2 != 0)
                .count();
        System.out.println("Number of odd numbers: " + oddCount);
    }
}
