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
```

# Consumer Interface in Java

The `Consumer` interface in Java is an in-built functional interface in the `java.util.function` package. It is used when there's a need to consume objects, where the consumer takes an input value and returns nothing. The `Consumer` interface consists of two methods:

## 1. `accept(T value)`

This method is used to accept an input value of type `T` and perform some operation on it. It returns void, indicating that it does not produce any result.

```java
void accept(T value);
```

# Predicate Interface in Java

The `Predicate` interface in Java is a functional interface that accepts an argument of type `T` and returns a boolean value. It is commonly used to apply filters to collections of objects.

## 1. `boolean test(T value)`

This method evaluates the predicate on the given input value and returns true if the input satisfies the predicate's condition, otherwise returns false.

```java
boolean test(T value);
```

# Function Interface in Java

The `Function` interface in Java is another in-built functional interface in the `java.util.function` package. It represents a function that accepts one argument and produces a result. This interface is commonly used in the map feature of Stream APIs.

## 1. `R apply(T var1)`

This method applies this function to the given argument and returns the result.

```java
R apply(T var1);
default <V> Function<V, R> compose(Function<V, T> before);
default <V> Function<T, V> andThen(Function<R, V> after);
static <T> Function<T, T> identity();
````

# Supplier Interface in Java

The `Supplier` interface in Java is a part of the `java.util.function` package. It represents a function that does not take in any arguments but produces a value of type `T`. It contains only one method.

## 1. `T get()`

This method retrieves a value of type `T`.

```java
T get();
```