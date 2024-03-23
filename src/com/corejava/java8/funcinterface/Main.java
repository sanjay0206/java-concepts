package com.java8.funcinterface;

// If we want to restrict the interface to have only one method we can use functional interface

@FunctionalInterface
interface A {
    // Static method
    static void hey() {
        System.out.println("This is hey method.");
    }

    // Abstract method
    void display(String message);

    // Default method
    default void hello() {
        System.out.println("This is hello method.");
    }

    // void add();

    String toString(); // if you have any method which is in object class it will not complain
}

//class B implements A {
//
//    @Override
//    public void show() {
//        System.out.println("This is show method.");
//    }
//
//    public String toString() {
//        return "My to String method";
//    }
//}

public class Main {
    public static void main(String[] args) {
//        A obj = new B();
//        obj.show();

        // What if the B class will be used only once in the entire project?
        // If we have more class then we have maintain more files and docs for one file,
        // So avoid this we go for Functional Interface.
        A obj = (message) -> System.out.println("Hi! " + message);
        obj.display("This is a message.");

        String myToString = obj.toString();
        System.out.println(myToString);

        obj.hello();
        A.hey();
    }
}

/*
O/P:
Hi! This is a message.
com.java8.funcinterface.Main$$Lambda$1/2003749087@41629346
This is hello method.
This is hey method.
*/
