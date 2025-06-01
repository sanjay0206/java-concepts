# Method References in Java

Method references in Java 8 are a shorthand notation of a lambda expression that allows you to refer to a method by its name. They provide a clear and concise way to express instances of functional interfaces, making the code more readable.

## Types of Method References

1. **Reference to a Static Method:**
    - **Syntax:** `ClassName::staticMethodName`
    - **Lambda Expression Equivalent:**
      ```java
      (parameters) -> ClassName.staticMethodName(parameters);
      ```
    - **Example:**
      ```java
      // Static method reference
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
      numbers.stream().map(MathUtils::square).forEach(System.out::println);
 
      // Equivalent lambda expression
      numbers.stream().map(x -> MathUtils.square(x)).forEach(System.out::println);
      ```

2. **Reference to an Instance Method of a Particular Object:**
    - **Syntax:** `instance::instanceMethodName`
    - **Lambda Expression Equivalent:**
      ```java
      (parameters) -> instance.instanceMethodName(parameters)
      ```
    - **Example:**
      ```java
      // Instance method reference
      String prefix = "Hello, ";
      Function<String, String> greet = prefix::concat; // Using instance method reference
 
      System.out.println(greet.apply("Alice")); // Output: Hello, Alice
 
      // Equivalent lambda expression
      Function<String, String> greetLambda = name -> prefix.concat(name);
      ```

3. **Reference to an Instance Method of an Arbitrary Object of a Particular Type:**
    - **Syntax:** `ClassName::instanceMethodName`
    - **Lambda Expression Equivalent:**
      ```java
      (object, parameters) -> object.instanceMethodName(parameters)
      ```
    - **Example:**
      ```java
      // Instance method of arbitrary object reference
      List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
      names.sort(String::compareTo); // Using instance method reference
 
      // Equivalent lambda expression
      names.sort((s1, s2) -> s1.compareTo(s2));
      ```

4. **Reference to a Constructor:**
    - **Syntax:** `ClassName::new`
    - **Lambda Expression Equivalent:**
      ```java
      (parameters) -> new ClassName(parameters)
      ```
    - **Example:**
      ```java
      // Constructor reference
      Supplier<List<String>> listSupplier = ArrayList::new; // Using constructor reference
      List<String> list = listSupplier.get();
 
      // Equivalent lambda expression
      Supplier<List<String>> listSupplierLambda = () -> new ArrayList<>();
      List<String> listLambda = listSupplierLambda.get();
      ```

## Summary Table

| Method Reference Type                                    | Syntax                       | Lambda Expression Equivalent                                      |
|---------------------------------------------------------|------------------------------|------------------------------------------------------------------|
| **Static Method Reference**                              | `ClassName::staticMethodName` | `(parameters) -> ClassName.staticMethodName(parameters)`        |
| **Instance Method of a Particular Object**              | `instance::instanceMethodName` | `(parameters) -> instance.instanceMethodName(parameters)`        |
| **Instance Method of an Arbitrary Object**              | `ClassName::instanceMethodName` | `(object, parameters) -> object.instanceMethodName(parameters)`  |
| **Constructor Reference**                                | `ClassName::new`            | `(parameters) -> new ClassName(parameters)`                      |

## Advantages of Method References

1. **Conciseness:** They reduce boilerplate code by eliminating the need to specify parameter types explicitly.
2. **Clarity:** They make the intention clearer by directly pointing to existing methods.
3. **Reusability:** They encourage the reuse of existing methods instead of duplicating logic.
4. **Type Inference:** The compiler can infer the types of parameters, which reduces the need for explicit type declarations.

## Example Code

Here’s an example that incorporates all types of method references:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // Reference to a static method
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.stream().map(MathUtils::square).forEach(System.out::println);

        // Reference to an instance method of a particular object
        String prefix = "Hello, ";
        Function<String, String> greet = prefix::concat; // Instance method reference
        System.out.println(greet.apply("Alice")); // Output: Hello, Alice

        // Reference to an instance method of an arbitrary object
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareTo); // Using instance method reference
        names.forEach(System.out::println);

        // Reference to a constructor
        Supplier<List<String>> listSupplier = ArrayList::new; // Constructor reference
        List<String> list = listSupplier.get();
    }
}

class MathUtils {
    public static int square(int x) {
        return x * x;
    }
}