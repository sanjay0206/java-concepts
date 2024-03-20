package com.corejava.collections.Maps;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        // Creating a TreeMap
        SortedMap<Integer, String> fileExtensions  = new TreeMap<>();

        // Adding new key-value pairs to a TreeMap
        fileExtensions.put(1, "python");
        fileExtensions.put(3, "c++");
        fileExtensions.put(2, "kotlin");
        fileExtensions.put(5, "golang");
        fileExtensions.put(4, "java");
        
        // duplicates keys are not allowed but values are allowed
        fileExtensions.put(6, "java");
        
      //  fileExtensions.put(null, "C"); // will throw java.lang.NullPointerException
        
        // Printing the TreeMap (Output will be sorted based on keys)
        fileExtensions.forEach((skill, rating) -> {
            System.out.println(skill + " => " + rating);
        });
 
    }

}