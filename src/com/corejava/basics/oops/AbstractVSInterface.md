
# Abstract Class vs Interface in Java

| Feature                   | Abstract Class                       | Interface                             |
|---------------------------|-------------------------------------|---------------------------------------|
| **Definition**            | A class that cannot be instantiated and can contain both abstract and concrete methods. | A reference type that can contain only abstract methods (Java 8 and later can have default and static methods). |
| **Method Implementation** | Can have both abstract methods (without a body) and concrete methods (with a body). | All methods are abstract by default (until Java 8), unless they are default or static methods. |
| **Constructor**           | Can have constructors.             | Cannot have constructors.             |
| **State**                 | Can have instance variables (state). | Cannot have instance variables, only constants (static final variables). |
| **Multiple Inheritance**  | A class can extend only one abstract class (single inheritance). | A class can implement multiple interfaces (multiple inheritance). |
| **Accessibility Modifiers** | Can use any access modifier (public, protected, private). | All methods are implicitly public; cannot use other access modifiers for methods. |
| **Use Case**              | Used when classes share a common base with shared implementation or state. | Used to define a contract that can be implemented by any class, promoting a common behavior. |
| **Default Methods**       | Not applicable.                     | Can have default methods (with a body) since Java 8. |
| **Functional Interfaces**  | Not applicable.                    | Can be used to define functional interfaces (with a single abstract method). |

## Summary
- Use **abstract classes** when you want to share code among closely related classes and when you need to maintain state.
- Use **interfaces** when you want to define a contract for classes that can be implemented by any class, regardless of the class hierarchy, especially when multiple inheritance is needed.


## Use Case Examples

### Abstract Class Example: Vehicle
This example demonstrates the use of an **Abstract Class** for a hierarchy of related classes. Here, `Vehicle` is an abstract class with shared state (`speed` and `fuel`) and a concrete method `refuel()` that is common to all types of vehicles. The `move()` method is abstract because each type of vehicle (like `Car` and `Airplane`) has a different implementation for it. This allows us to provide common functionality while allowing subclasses to define their specific behaviors.

```java
abstract class Vehicle {
    int speed; // shared state
    int fuel;

    public Vehicle(int speed, int fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    // Concrete method
    public void refuel(int amount) {
        fuel += amount;
        System.out.println("Refueled. Fuel level: " + fuel);
    }

    // Abstract method
    public abstract void move(); // Different vehicles move differently
}

class Car extends Vehicle {
    public Car(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public void move() {
        System.out.println("The car is driving at speed: " + speed);
    }
}

class Airplane extends Vehicle {
    public Airplane(int speed, int fuel) {
        super(speed, fuel);
    }

    @Override
    public void move() {
        System.out.println("The airplane is flying at speed: " + speed);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(120, 50);
        Vehicle airplane = new Airplane(600, 100);

        car.refuel(20);
        car.move(); // Output: The car is driving at speed: 120

        airplane.refuel(100);
        airplane.move(); // Output: The airplane is flying at speed: 600
    }
}
```

### Interface Example: Document
This example shows the use of an **Interface** to define a common contract that different types of documents (like `PDFDocument`, `WordDocument`, and `ExcelDocument`) must follow. The interface `Document` declares the methods `open()`, `close()`, and `save()` that all document types should implement. This approach allows unrelated classes to share a common behavior without being part of the same class hierarchy.

```java
interface Document {
    void open();
    void close();
    void save();
}

class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document...");
    }
}

public class DocumentMain {
    public static void main(String[] args) {
        Document pdf = new PDFDocument();
        Document word = new WordDocument();
        Document excel = new ExcelDocument();

        // Opening and saving each document
        pdf.open();
        pdf.save();
        pdf.close();

        word.open();
        word.save();
        word.close();

        excel.open();
        excel.save();
        excel.close();
    }
}
```
