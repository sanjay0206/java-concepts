# Spring Dependency Injection

### Overview
* Spring Dependency Injection (DI) is a powerful design pattern used to achieve Inversion of Control (IoC) in Spring applications.
* DI allows you to inject dependencies into objects, rather than creating them within the objects, leading to a more modular, testable, and maintainable codebase.

### Advantages of Dependency Injection
1. **Loose Coupling**: Reduces the tight coupling between objects, allowing them to be more modular and easier to maintain.
2. **Easier Testing**: Simplifies unit testing by allowing mock dependencies to be injected.
3. **Improved Code Quality**: Encourages a clean, modular design, making the codebase more readable and maintainable.

### Types of Dependency Injection
Spring supports several types of dependency injection:
1. **Field Injection**
2. **Setter Injection**
3. **Constructor Injection**

### 1. Field Injection
* Dependency is set into fields of class
* Spring uses reflection, it iterates over fields and resolve dependencies

#### Advantages
* Simple and easy to use

#### Disadvantages
* Cannot be used with immutable fields
* Chances of NPE

### 2. Setter Injection
* Dependency is set using setter of field
* We have to annotate the method using `@Autowired`

#### Advantages
* Dependency can be changed anytime after object creation
* Easy for JUnit testing, we can pass mock objects in dependency easily

#### Disadvantages
* Cannot be used with immutable fields, ie) field cannot be marked as final
* Difficult to read and maintain, as per standards.

### 3. Constructor Injection
* Dependency will be resolved at the time of initialization of object
* It's the recommended approach
* When 1 constructor is present, `@Autowired` is not mandatory

#### Advantages
* All mandatory dependencies will be injected at the time of initialization itself
* Makes 100% sure that our object will be initialized will the required dependencies
* Avoids NPE
* We can create immutable object using constructor injection
* Fail Fast - Fail at compilation only in case of any missing dependencies

#### Disadvantages
* No significant disadvantages.

### Common Problems
* **Circular Dependency**: Occurs when two or more beans reference each other, leading to a cycle. (Can use `@Lazy` to avoid it)
* **Unsatisfied Dependency**: Occurs when a required dependency is not found in the context.


