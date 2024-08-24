package com.corejava.collections.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeQueueEx {

    /*
    Bounded Queue:
        Has a fixed capacity.
        May block or throw exceptions when full.
        Examples: ArrayBlockingQueue, LinkedBlockingQueue.

    Unbounded Queue:
        No fixed capacity limit.
        Will grow as needed until system memory is exhausted.
        Examples: ArrayDeque, LinkedList.

    offer:
    -> Returns false if the queue is full and cannot accept more elements (for bounded queues).
    -> Preferred for queues where you need to handle the possibility of not being able to add elements.

    add:
    -> Throws an IllegalStateException if the queue is full and cannot accept more elements (for bounded queues).
    -> Generally used for unbounded queues or where you expect that the queue will always have capacity to add elements.
    */

    public static void main(String[] args) {
        Queue<String> callQueue = new ArrayDeque<>();

        // Enqueue incoming calls
        callQueue.offer("Call from Customer A");
        callQueue.offer("Call from Customer B");
        callQueue.offer("Call from Customer C");

        // Peek at the front element of the queue (without removing it)
        System.out.println("Peek: " + callQueue.peek());

        // Remove elements from the queue
        System.out.println("Removing: " + callQueue.poll()); // Removes "Element 1"

        // Handling calls
        System.out.println("Handling calls:");
        while (!callQueue.isEmpty()) {
            System.out.println("Handling: " + callQueue.poll());
        }
    }
}

/*
Peek: Call from Customer A
Removing: Call from Customer A
Handling calls:
Handling: Call from Customer B
Handling: Call from Customer C
*/