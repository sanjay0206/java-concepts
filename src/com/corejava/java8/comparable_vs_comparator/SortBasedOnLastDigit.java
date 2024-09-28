package com.corejava.java8.comparable_vs_comparator;

import java.util.*;

public class SortBasedOnLastDigit {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(43, 31, 72, 29, 69));
        System.out.println(nums);

        // sort the array
        Collections.sort(nums);
        System.out.println(nums);

        // what if we want to sort with our own logic?
        // if you want the array based on the last digit of the element
        Comparator<Integer> comparator = (o1, o2) -> {
            // 1 it will swap, -1 it will not swap
            int rem1 = o1 % 10;
            int rem2 = o2 % 10;
            if (rem1 > rem2)
                return 1;
            else if (rem1 < rem2)
                return -1;
            else
                return 0;

            // return Integer.compare(rem1, rem2);
        };

        nums.sort(comparator);
        System.out.println(nums);
    }
}
