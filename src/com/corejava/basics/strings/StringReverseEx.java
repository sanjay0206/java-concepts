package com.corejava.basics.strings;

import java.util.Arrays;
import java.util.List;

public class StringReverseEx {

    public static void reverseList(List<String> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            String temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }

    public static String reverse(String str) {
        int start = 0;
        int end = str.length() - 1;

        StringBuilder sb = new StringBuilder(str);
        while (start < end)  {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("sanjay", "hari", "karthi", "koushik");

        System.out.println(list);
        reverseList(list);
        System.out.println(list);

        String name = "Animal";
        System.out.println(name);
        System.out.println(reverse(name));
    }
}
