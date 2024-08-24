package com.corejava.collections.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {

    public static void main(String[] args) {
        // PriorityQueue with custom priority based on urgency
        Queue<Task> taskQueue = new PriorityQueue<>();

        // Adding tasks with different priorities
        taskQueue.offer(new Task("Fix critical bug", 1)); // Highest priority
        taskQueue.offer(new Task("Review code", 3));
        taskQueue.offer(new Task("Update documentation", 2)); // Medium priority

        // Processing tasks based on priority
        System.out.println("Processing tasks by priority:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing: " + task.getDescription());
        }
    }

}

/*
Processing tasks by priority:
Processing: Fix critical bug
Processing: Update documentation
Processing: Review code
*/
