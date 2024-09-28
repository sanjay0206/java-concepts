package com.corejava.java8.funcinterface.violation;

public interface IDish {
    void cook(String ingredients);

    // Violation
    void serve();
}