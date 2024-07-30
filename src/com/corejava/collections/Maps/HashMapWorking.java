package com.corejava.collections.Maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapWorking {
    public static void main(String[] args) {

        Map<String, Integer> nameMap = new HashMap<>();
        nameMap.put("karthik", 28);
        nameMap.put("Jessi", 24);
        nameMap.put("Ram", 32);
        nameMap.put("Janu", 28);
        nameMap.put("Pradeep", 24);
        nameMap.put("Nikitha", 24);

        for (String key : nameMap.keySet()) {
            System.out.println("key = " + key + ", hash = " + Math.abs(key.hashCode()) + ", index = " + (Math.abs(key.hashCode()) % 15));
        }
    }
}

/*
key = Pradeep, hash = 1342234603, index = 13
key = Jessi, hash = 71463630, index = 0
key = Nikitha, hash = 681036460, index = 10
key = Janu, hash = 2301278, index = 8
key = karthik, hash = 935485838, index = 8
key = Ram, hash = 81918, index = 3
*/