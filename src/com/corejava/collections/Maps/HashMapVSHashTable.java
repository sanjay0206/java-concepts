package com.corejava.collections.Maps;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapVSHashTable {
    public static void getHashTable() {
        HashMap<String, String> hm = new HashMap<>();

        hm.put("key1", "value1");
        hm.put(null, "first_null");
        hm.put(null, "second_null");
        hm.put(null, "third_null");
        hm.put("key2", null);
        hm.put("key3", null);
        hm.put("key4", null);

        System.out.println("Hash Map size before iteration: " + hm.size());

        for (Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void getHashMap() {
        Hashtable<Integer, String> ht = new Hashtable<>();

        ht.put(1, "Java");
        ht.put(2, "Python");
        ht.put(3, "Scala");

        // Will throw NullPointerException since Hash Map will not allow null key and null value
//        ht.put(null, "null_key");
//        ht.put(4, null);

        System.out.println("Hash Table size before iteration: " + ht.size());

//        for (Map.Entry<Integer, String> entry : ht.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        Enumeration<String> e = ht.elements();
        while (e.hasMoreElements()) {
            System.out.println("element: " + e.nextElement());
        }
    }
    public static void main(String[] args) {
        getHashTable();

        getHashMap();
    }

}

/*
Hash Map size before iteration: 5
key1: value1
null: third_null
key2: null
key3: null
key4: null
Hash Table size before iteration: 3
element: Scala
element: Python
element: Java
*/
