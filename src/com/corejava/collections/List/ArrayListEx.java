package List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListEx {
    public static void main(String[] args) {
        List<String> topCompanies = new ArrayList<>();

        // Check if an ArrayList is empty
        System.out.println("Is the topCompanies list empty? : " + topCompanies.isEmpty()); // true

        topCompanies.add("Google");
        topCompanies.add("Apple");
        topCompanies.add("Microsoft");
        topCompanies.add("Amazon");
        topCompanies.add("Facebook");

        // Find the size of an ArrayList
        System.out.println("Here are the top " + topCompanies.size() + " companies in the world"); // Here are the top 5 companies in the world
        System.out.println(topCompanies); // [Google, Apple, Microsoft, Amazon, Facebook]

        // Retrieve the element at a given index
        String bestCompany = topCompanies.get(0);
        String secondBestCompany = topCompanies.get(1);
        String lastCompany = topCompanies.get(topCompanies.size() - 1);

        System.out.println("Best Company: " + bestCompany); // Best Company: Google
        System.out.println("Second Best Company: " + secondBestCompany); // Second Best Company: Apple
        System.out.println("Last Company in the list: " + lastCompany); // Last Company in the list: Facebook

        // Modify the element at a given index
        topCompanies.set(4, "Walmart");
        System.out.println("Modified top companies list: " + topCompanies); // Modified top companies list: [Google, Apple, Microsoft, Amazon, Walmart

        // Searching for a element in List
        System.out.println("Does topCompanies array contain Microsoft? " + topCompanies.contains("Microsoft"));

        System.out.println("Before sorting: " + topCompanies); // Before sorting: [Google, Apple, Microsoft, Amazon, Walmart]
        // Collections.sort(topCompanies);
        // topCompanies.sort((company1, company2) -> company1.compareTo(company2));
        topCompanies.sort(Comparator.naturalOrder());  // Following is an even more concise solution
        // System.out.println("After sorting: " + topCompanies);

        // Sorting in reverse order 
        // Collections.sort(topCompanies, Collections.reverseOrder());
        topCompanies.sort(Comparator.reverseOrder());

        System.out.println("After sorting in reverse: " + topCompanies); // After sorting in reverse: [Walmart, Microsoft, Google, Apple, Amazon]

        // Remove the element at index `2`
        topCompanies.remove(2);
        System.out.println("After removing the company at index 2: " + topCompanies); // After removing the company at index 2: [Walmart, Microsoft, Apple, Amazon]

        // Remove all elements from the ArrayList
        topCompanies.clear();
        System.out.println("After clear(): " + topCompanies); // After clear(): []

    }
}