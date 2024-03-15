package Queue;

import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        // Create a Priority Queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        // Add items to a Priority Queue (ENQUEUE)
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);
        System.out.println("PriorityQueue: " + numbers);
        numbers.offer(1);
   
        System.out.println("Updated PriorityQueue: " + numbers);

        // Remove items from the Priority Queue (DEQUEUE)
        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }

    }
}