
# Functional Interface in Java

## Overview

* A functional interface in Java is **an interface with exactly one abstract method**. It allows the use of **lambda expressions** and **method references** introduced in Java 8. 
* The `@FunctionalInterface` annotation can be used to mark such interfaces, though it's not mandatory.

**NOTE:**  
* Any interface with a **single abstract method (SAM)** qualifies as a functional interface, even if it was introduced long before Java 8. 
* These interfaces can be used with lambda expressions and method references from Java 8 onwards. You can also use the `@FunctionalInterface` annotation to explicitly mark them as functional interfaces.

##  Predefined Functional Interfaces
**1. Runnable:** The `Runnable` interface contains only the `run()` method. It allows you to write applications that can run on separate threads.

**2. Callable:** The `Callable` interface contains only the `call()` method. This method allows you to monitor the progress of a thread's execution and can return a result or throw an exception.

**3. Comparator:** The `Comparator` interface contains the `compare()` method. This allows for custom sorting of objects by defining different criteria than natural ordering.

**4. Comparable:** The `Comparable` interface contains only the `compareTo()` method. Classes implementing this interface can compare and sort their objects.

**5. Iterable:** The `Iterable` interface contains only the `iterator()` method. This method provides an iterator over a collection.

**5. ActionListener:** `ActionListener` interface contains the `actionPerformed()` method. This component handles all the action events, such as mouse clicks on components.

## Types of Functional interfaces
**1. Consumer:** The Consumer interface takes an input and does something with it, but doesn't return anything

```java
void accept(T value);

default Consumer<T> andThen(Consumer<? super T> after);
```

**2. Predicate:** The Predicate interface checks a condition on an input and returns true or false.

```java
boolean test(T value);

default Predicate<T> and(Predicate<? super T> other);
default Predicate<T> or(Predicate<? super T> other);
static <T> Predicate<T> isEquals(Object targetRef);
default Predicate<T> negate();
```

**3. Function:** The Function interface takes an input, processes it, and returns a result.

```java
R apply(T var1);

default <V> Function<V, R> compose(Function<V, T> before);
default <V> Function<T, V> andThen(Function<R, V> after);
static <T> Function<T, T> identity();
```

**4. Supplier:** The Supplier interface provides a result without taking any input.

```java
T get();
```

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