# Inheritance vs Aggregation vs Composition

**Inheritance**: "is-a" relationship, where one class inherits properties and behaviors from another.

**Aggregation**: "has-a" relationship with weaker coupling; the part can exist independently of the whole.

**Composition***: Stronger "has-a" relationship with strong coupling; the part depends on the whole for its existence.

## 1. Inheritance
**Concept**: Inheritance is a mechanism where one class (the child or subclass) derives from another class (the parent or superclass), inheriting its attributes and behaviors (methods).

**Usage**: It is used to establish a "is-a" relationship between classes. For example, if `Dog` is a subclass of `Animal`, then a `Dog` is an `Animal`.

**Example**:
```java
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }
}
```
Here, Dog inherits the eat() method from Animal and adds its own method bark().

**Pro**:
Promotes code reuse.
Establishes a clear hierarchy.

**Cons**:
Can lead to a rigid structure, making changes more difficult.
Tight coupling between parent and child classes.


## 2. Aggregation
**Concept**: Aggregation represents a "has-a" relationship where one class contains a reference to another class but both can exist independently. The contained object (part) can exist independently of the container (whole).

**Usage**: It is used when the lifetime of the contained object does not depend on the lifetime of the container. For example, a Library can have Books, but Books can exist without the Library.

**Example**:
```java
class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

class Library {
    List<Book> books;

    Library(List<Book> books) {
        this.books = books;
    }
}
```
Here, Library aggregates Book objects, but the Book objects can exist outside the Library.

**Pro**:
Flexible relationship between classes.
Reduces coupling compared to inheritance.

**Cons**:
Still involves some level of dependency.


## 3. Composition
**Concept**: Composition is a stronger form of aggregation, where one class is composed of one or more objects of other classes, and the composed objects do not exist independently of the container. If the container object is destroyed, the composed objects are also destroyed.

**Usage**: It is used when the lifetime of the composed objects is tightly coupled with the container. For example, a House is composed of Rooms, and if the House is destroyed, the Rooms are destroyed as well

**Example**:
```java
class Engine {
    void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private Engine engine;

    Car() {
        engine = new Engine(); // Car creates the Engine
    }

    void startCar() {
        engine.start();
    }
}
```
Here, Car is composed of an Engine, and the Engine cannot exist independently of the Car.

**Pro**:
Strong encapsulation.
More flexibility compared to inheritance.

**Cons**:
Can lead to complex structures if overused.

