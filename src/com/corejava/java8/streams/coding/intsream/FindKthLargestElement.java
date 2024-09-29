package com.corejava.java8.streams.coding.intsream;

import java.util.Arrays;
import java.util.Comparator;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int[] numbers = {7, 10, 4, 3, 20, 15};
        int k = 3;  // 3rd largest element

        int kthLargest = Arrays.stream(numbers)
                .boxed()
              //  .sorted(Comparator.reverseOrder())
                .sorted((a, b) -> b - a)
                .skip(k-1)
                .findFirst()
                .orElse(0);

        System.out.println(k + "rd largest element: " + kthLargest);
    }
}
