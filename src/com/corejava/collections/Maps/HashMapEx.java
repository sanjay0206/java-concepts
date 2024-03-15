package Maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, String> countryISOCodeMapping = new HashMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");
        countryISOCodeMapping.put("China", "CN");
        
        // will not allow duplicates keys but values are allowed
        countryISOCodeMapping.put("China", "CN");
        
        // will allow null keys 
        countryISOCodeMapping.put(null, "CN");
        countryISOCodeMapping.put(null, "SA");
        
        // No duplicates are allowed
        countryISOCodeMapping.put("China", "CN");
        
        // Adding the elements if it doesn't exists in the Map
        countryISOCodeMapping.putIfAbsent("Maldives", "MD");

        // HashMap's entry set
        Set<Map.Entry<String, String>> countryISOCodeEntries = countryISOCodeMapping.entrySet();
        System.out.println("countryISOCode entries : " + countryISOCodeEntries);

        // HashMap's key set
        Set<String> countries = countryISOCodeMapping.keySet();
        System.out.println("countries : " + countries);
        

        // HashMap's values
        Collection<String> isoCodes = countryISOCodeMapping.values();
        System.out.println("isoCodes : " + isoCodes);
        
        // Check if a key exists in a HashMap
        System.out.println(countryISOCodeMapping.containsKey("India"));

        // Check if a value exists in a HashMap
        System.out.println(countryISOCodeMapping.containsKey("MD"));
        
        // Iterating a HashMap using forEach
        countryISOCodeMapping.forEach((country, code) -> {
            System.out.println(country + " => " + code);
        });
 
    }
}