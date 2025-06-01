package com.corejava.basics.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestException {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
//        for (String item : list) {
//            if (item.equals("C")) {
//                list.remove(item); // ConcurrentModificationException
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("C")) {
                iterator.remove(); // Safe removal using Iterator's remove method
            }
        }
    }
}
