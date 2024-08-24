package com.corejava.collections.Queue;

public class Task implements Comparable<Task> {
    private String description;
    private int priority;

        public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}