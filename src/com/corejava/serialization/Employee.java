package com.corejava.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    /* Employee class has a field named bankAccountNumber, which should be excluded
       during the serialization process to ensure sensitive data is not persisted. */
    private transient String bankAccountNumber;

    // Constructor
    public Employee(String name, int age, String bankAccountNumber) {
        this.name = name;
        this.age = age;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                '}';
    }
}