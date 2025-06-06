package com.corejava.collections.Sets;

import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        TreeSet<String> students = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        students.add("Julia");
        students.add("Robert");
        students.add("Mark");
        students.add("Steven");

        // No duplicates are allowed
        students.add("Steven");

        System.out.println("Students TreeSet : " + students);

        // Finding the size of a TreeSet
        System.out.println("Number of elements in the TreeSet : " + students.size());

        // Check if an element exists in the TreeSet
        String name = "Julia";
        if (students.contains(name))
            System.out.println("TreeSet contains the element : " + name);
        else
            System.out.println("TreeSet does not contain the element : " + name);

        // Navigating through the TreeSet
        System.out.println("First element : " + students.first());
        System.out.println("Last element : " + students.last());

        name = "Robert";
        System.out.println("Element just greater than " + name + " : " + students.higher(name));
        System.out.println("Element just lower than " + name + " : " + students.lower(name));

    }
}

/*
Students TreeSet : [Julia, Mark, Robert, Steven]
Number of elements in the TreeSet : 4
TreeSet contains the element : Julia
First element : Julia
Last element : Steven
Element just greater than Robert : Steven
Element just lower than Robert : Mark
*/
