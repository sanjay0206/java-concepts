
# Data Type Hierarchy and Conversions in Java

## 1. Primitive Data Types Hierarchy
Java has 8 primitive data types, categorized into four main groups:

### **Integral Types**
- `byte` ? `short` ? `int` ? `long`

### **Floating-Point Types**
- `float` ? `double`

### **Character Type**
- `char`

### **Boolean Type**
- `boolean`

### Each primitive data type in Java has a specific range, depending on its size:

| Data Type | Size    | Min Value                       | Max Value                        |
|-----------|---------|---------------------------------|---------------------------------|
| `byte`    | 1 byte  | -128                            | 127                             |
| `short`   | 2 bytes | -32,768                         | 32,767                          |
| `int`     | 4 bytes | -2,147,483,648                  | 2,147,483,647                   |
| `long`    | 8 bytes | -9,223,372,036,854,775,808      | 9,223,372,036,854,775,807       |
| `float`   | 4 bytes | 1.4E-45 (approx)                | 3.4E+38 (approx)                |
| `double`  | 8 bytes | 4.9E-324 (approx)               | 1.7E+308 (approx)               |
| `char`    | 2 bytes | 0 (`\u0000`)                    | 65,535 (`\uffff`)               |
| `boolean` | 1 byte  | `false`                         | `true`                          |

**Note:**
- The ranges for floating-point types (`float` and `double`) are approximate and depend on precision.
- `char` represents a single Unicode character and has no negative values.

## 2. Data Type Widening Conversion (Upcasting) Tree

```
                    [byte]
                      ?
                    [short]
                      ?
                    [int]
                      ?
                    [long]
                      ?
                   [float]
                      ?
                   [double]
```

**Note:**
- `char` can be directly upcasted to `int`, `long`, `float`, or `double`.
- `boolean` cannot be converted to or from any numeric type.

## 3. Conversion Rules
- **Widening Conversion (Upcasting)**: It is safe and happens automatically.
    - Examples: `byte` ? `short`, `int` ? `long`, `float` ? `double`
- **Narrowing Conversion (Downcasting)**: It is explicit and may lose data.
    - Examples: `double` ? `float`, `long` ? `int`, `int` ? `short`

## 4. Data Type Narrowing Conversion (Downcasting) Tree

```
                   [double]
                      ?
                   [float]
                      ?
                    [long]
                      ?
                    [int]
                      ?
                    [short]
                      ?
                    [byte]
```

## 5. Special Conversions
- `char` can be upcasted to `int`, `long`, `float`, and `double` but not to `byte` or `short` directly without casting.
- `boolean` is a standalone type and is not involved in numerical conversions.

## Examples of Upcasting and Downcasting

### Upcasting Example
```java
int intNumber = 42;
double doubleNumber = intNumber; // Implicit upcasting
System.out.println("Double value: " + doubleNumber); // Output: 42.0
```

### Downcasting Example
```java
double doubleValue = 42.5;
int intValue = (int) doubleValue; // Explicit downcasting
System.out.println("Int value: " + intValue); // Output: 42 (fractional part is lost)
```

---

# Upcasting and Downcasting in Java

## Upcasting and Downcasting with Data Types

### Upcasting (Widening Conversion)
Upcasting involves converting a smaller data type to a larger data type. This conversion is implicit and safe, as no data is lost.

#### Example of Data Type Upcasting

```java
public class UpcastingExample {
    public static void main(String[] args) {
        int intNumber = 100;

        // Upcasting from int to double (widening conversion)
        double doubleNumber = intNumber; // Implicit upcasting

        System.out.println("Integer value: " + intNumber); // Output: Integer value: 100
        System.out.println("Double value: " + doubleNumber); // Output: Double value: 100.0
    }
}
```

### Downcasting (Narrowing Conversion)
Downcasting involves converting a larger data type to a smaller data type. This conversion is explicit and can result in data loss.

#### Example of Data Type Downcasting

```java
public class DowncastingExample {
    public static void main(String[] args) {
        double doubleNumber = 100.25;

        // Downcasting from double to int (narrowing conversion)
        int intNumber = (int) doubleNumber; // Explicit downcasting

        System.out.println("Double value: " + doubleNumber); // Output: Double value: 100.25
        System.out.println("Integer value: " + intNumber);   // Output: Integer value: 100
    }
}
```

## Upcasting and Downcasting with Object References

### Upcasting with Object References
Upcasting refers to treating a subclass object as an instance of its superclass. This is implicit and used for generalization and polymorphism.

#### Example of Object Upcasting

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car is starting");
    }

    void drive() {
        System.out.println("Car is driving");
    }
}

public class ObjectUpcastingExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        // Upcasting: Car reference is treated as Vehicle reference
        Vehicle myVehicle = myCar; // Implicit upcasting

        myVehicle.start(); // Output: Car is starting (overridden method)

        // myVehicle.drive(); // Compile-time error: drive() is not defined in Vehicle
    }
}
```

### Downcasting with Object References
Downcasting refers to converting a superclass reference back to a subclass reference. This is explicit and should be handled carefully to avoid runtime errors.

#### Example of Object Downcasting

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car is starting");
    }

    void drive() {
        System.out.println("Car is driving");
    }
}

public class ObjectDowncastingExample {
    public static void main(String[] args) {
        Vehicle myVehicle = new Car(); // Upcasting

        myVehicle.start(); // Output: Car is starting

        // Downcasting to access subclass-specific method
        if (myVehicle instanceof Car) {
            Car myCar = (Car) myVehicle; // Explicit downcasting
            myCar.drive(); // Output: Car is driving
        }

        // Potential error scenario
        Vehicle anotherVehicle = new Vehicle(); // Not a Car instance
        // Car anotherCar = (Car) anotherVehicle; // This will cause ClassCastException
    }
}
```

## Key Differences Between Upcasting and Downcasting

| Feature                   | Upcasting                               | Downcasting                         |
|---------------------------|-----------------------------------------|-------------------------------------|
| **Data Type**             | Smaller to larger data type             | Larger to smaller data type         |
| **Object Reference Type** | Subclass reference to superclass reference | Superclass reference to subclass reference |
| **Conversion**            | Implicit (automatic)                    | Explicit (requires casting)         |
| **Data Loss**             | No                                      | Possible                            |
| **Use Case**              | Generalization, polymorphism            | Access subclass-specific features   |
