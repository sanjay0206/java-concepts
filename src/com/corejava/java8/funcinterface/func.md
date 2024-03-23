# Functional Interface in Java

## Overview

A functional interface in Java is an interface that contains exactly one abstract method. These interfaces play a
crucial role in enabling the use of lambda expressions and functional programming concepts introduced in Java 8.

### Definition

- A functional interface contains exactly one abstract method, which is intended to represent behavior that can be
  passed around as data.
- Functional interfaces are designed to support lambda expressions and method references, providing a more concise and
  expressive way to represent behavior as data.

### Example

```java
@FunctionalInterface
interface MyFunction {
    int apply(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        // Using a lambda expression to implement the apply method of the MyFunction interface
        MyFunction add = (a, b) -> a + b;

        // Using the apply method to add two numbers
        int result = add.apply(10, 20);
        System.out.println("Result of addition: " + result);
    }
}
