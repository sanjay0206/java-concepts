package com.corejava.collections.Maps;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {

    public static void hashMap() {

        Map<String, Double> movies = new HashMap<>();
        movies.put("Breaking Bad", 9.2);
        movies.put("Iron Man", 8.5);
        movies.put("The Dark Knight", 9.0);
        movies.put("Inception", 8.8);
        movies.put("The Matrix", 8.7);
        System.out.println("Movies: " + movies);

        try {
            for (String key : movies.keySet()) {
                movies.remove(key); // ConcurrentModificationException
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }

        // Use Fail safe iterator
        Iterator<String> iterator = movies.keySet().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove(); // Safely remove the entry
        }
        System.out.println("Movies: " + movies);
    }

    public static void concurrentHashMap() {
        Map<String, Double> movies = new ConcurrentHashMap<>();
        movies.put("Breaking Bad", 9.2);
        movies.put("Iron Man", 8.5);
        movies.put("The Dark Knight", 9.0);
        movies.put("Inception", 8.8);
        movies.put("The Matrix", 8.7);
        System.out.println("Movies: " + movies);

        for (String key : movies.keySet()) {
            movies.remove(key); // ConcurrentModificationException
        }

        // Movies: {Breaking Bad=9.2, Iron Man=8.5, The Dark Knight=9.0, The Matrix=8.7, Inception=8.8}
    }

    public static void main(String[] args) {
        concurrentHashMap();

        hashMap();
    }
}

/*
Movies: {Breaking Bad=9.2, Iron Man=8.5, The Dark Knight=9.0, The Matrix=8.7, Inception=8.8}
Movies: {}
java.util.ConcurrentModificationException
at java.util.HashMap$HashIterator.nextNode(HashMap.java:1445)
at java.util.HashMap$KeyIterator.next(HashMap.java:1469)
at com.corejava.collections.Maps.ConcurrentHashMapEx.main(ConcurrentHashMapEx.java:22)
*/
