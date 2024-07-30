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
