package List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> friends = new LinkedList<>();

        // Adding new elements to the end of the LinkedList using add() method.
        friends.add("Rajeev");
        friends.add("John");
        friends.add("David");
        friends.add("Chris");

        System.out.println("Initial LinkedList : " + friends); // Initial LinkedList : [Rajeev, John, David, Chris]

        // Adding an element at the specified position in the LinkedList
        friends.add(3, "Lisa");
        System.out.println("After add(3, \"Lisa\") : " + friends); // After add(3, "Lisa") : [Rajeev, John, David, Lisa, Chris]

        // Adding an element at the beginning of the LinkedList
        friends.addFirst("Steve");
        System.out.println("After addFirst(\"Steve\") : " + friends); // After addFirst("Steve") : [Steve, Rajeev, John, David, Lisa, Chris]

        // Adding an element at the end of the LinkedList (This method is equivalent to the add() method)
        friends.addLast("Jennifer");
        System.out.println("After addLast(\"Jennifer\") : " + friends); // After addLast("Jennifer") : [Steve, Rajeev, John, David, Lisa, Chris, Jennifer]

        // Adding all the elements from an existing collection to the end of the LinkedList
        List<String> familyFriends = new ArrayList<>();
        familyFriends.add("Jesse");
        familyFriends.add("Walt");

        friends.addAll(familyFriends);
        System.out.println("After addAll(familyFriends) : " + friends);
        // After addAll(familyFriends) : [Steve, Rajeev, John, David, Lisa, Chris, Jennifer, Jesse, Walt]

        // retrieving the first element of LinkedList
        System.out.println("First element : " + friends.getFirst()); // First element : Steve

        // retrieving the last element of LinkedList
        System.out.println("Last element : " + friends.getLast()); // Last element : Walt

        // removing the first element of LinkedList
        friends.removeFirst();
        System.out.println("After removing First element : " + friends); // After removing First element : [Rajeev, John, David, Lisa, Chris, Jennifer, Jesse, Walt]

        // removing the last element of LinkedList
        friends.removeLast();
        System.out.println("After removing Last element : " + friends); // After removing Last element : [Rajeev, John, David, Lisa, Chris, Jennifer, Jesse]

        // Remove all the elements that satisfy the given predicate
        friends.removeIf(friend -> friend.startsWith("J"));
        System.out.println("After removing elements starting with 'J': " + friends); // After removing elements starting with 'J': [Rajeev, David, Lisa, Chris]

    }
}
