package com.corejava.basics.oops.runtimepolymorphism;

class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound(); // Output: Woof
        cat.makeSound(); // Output: Meow
    }
}

/*
-> There is a base class Animal with a method makeSound().
-> Two subclasses Dog and Cat extend Animal and provide their specific implementations of the makeSound() method.
-> In the Main class, we create objects of type Animal but instantiate them as Dog and Cat respectively.
-> When calling makeSound() on these objects, the actual method implementation that gets executed is determined at runtime
   based on the type of the object being referenced. This is runtime polymorphism in action. So, even though the reference type
   is Animal, the method called depends on the actual object type (Dog or Cat).
*/
