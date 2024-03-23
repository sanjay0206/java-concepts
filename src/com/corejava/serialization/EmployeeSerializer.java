package com.corejava.serialization;

import java.io.*;

public class EmployeeSerializer {
    private static final String BASE_PATH = "src/com/corejava/serialization/";

    private static void serializeEmployee(Employee employee) {
        try {
            FileOutputStream fileOut = new FileOutputStream(BASE_PATH + "employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employee);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employee.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee deserializeEmployee() {
        try {
            FileInputStream fileIn = new FileInputStream(BASE_PATH + "employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee deserializedEmployee = (Employee) in.readObject();
            in.close();
            fileIn.close();
            return deserializedEmployee;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Serialization
        Employee employee = new Employee("John Doe", 30, "1234567890");
        serializeEmployee(employee);

        // Deserialization
        Employee deserializedEmployee = deserializeEmployee();
        System.out.println("Deserialized Employee: " + deserializedEmployee);
    }

}
/*
Serialized data is saved in employee.ser
Deserialized Employee: Employee{name='John Doe', age=30, bankAccountNumber='null'}
*/