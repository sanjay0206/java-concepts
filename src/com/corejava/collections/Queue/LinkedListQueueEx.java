package com.corejava.collections.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueEx {

    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();

        // Adding tasks to the queue
        tasks.offer("Complete project report");
        tasks.offer("Prepare presentation slides");
        tasks.offer("Submit final draft");
        tasks.offer("Schedule team meeting");

        // Processing tasks
        System.out.println("Processing tasks:");
        while (!tasks.isEmpty()) {
            System.out.println("Processing: " + tasks.poll());
        }

        System.out.println(tasks.size());
    }
}

/*
Processing tasks:
Processing: Complete project report
Processing: Prepare presentation slides
Processing: Submit final draft
Processing: Schedule team meeting
0
*/
