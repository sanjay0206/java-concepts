package com.corejava.collections.List;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        // Creating a Stack
        Stack<String> stackOfCards = new Stack<>();

        // Pushing new items to the Stack
        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");

        System.out.println("Stack => " + stackOfCards);

        // Popping items from the Stack
        String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);

        // Get the item at the top of the stack without removing it
        cardAtTop = stackOfCards.peek();
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);

        int position = stackOfCards.search("Queen");
        if (position != -1)
            System.out.println("Found the element Queen at position : " + position);
        else
            System.out.println("Element not found");


        System.out.print(Integer.MAX_VALUE);
    }
}
/*
Stack => [Jack, Queen, King, Ace]
        Stack.pop() => Ace
Current Stack => [Jack, Queen, King]
        Stack.peek() => King
Current Stack => [Jack, Queen, King]
Found the element Queen at position : 2
*/
