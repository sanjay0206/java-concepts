package com.corejava.java8.comparable_vs_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee implements Comparable<Employee> {
    private int employeeId;
    private double salary;
    private String deptName;

    public Employee() {
    }

    public Employee(int employeeId, double salary, String deptName) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.deptName = deptName;
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        // Inserting 5 employees
        employees.add(new Employee(103, 50000, "IT"));
        employees.add(new Employee(102, 60000, "HR"));
        employees.add(new Employee(105, 55000, "Finance"));
        employees.add(new Employee(104, 52000, "Marketing"));
        employees.add(new Employee(101, 58000, "Operations"));
        employees.forEach(System.out::println);

        Comparator<Employee> comparator = (Employee e1, Employee e2) -> {
            if (e1.salary > e2.salary)
                return 1;
            else if (e1.salary < e2.salary)
                return -1;
            else
                return 0;
        };

        System.out.println("==============================================================");
//            Collections.sort(employees, comparator);
        Collections.sort(employees);
        employees.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salary=" + salary +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee e) {
        return Double.compare(this.employeeId, e.employeeId);
    }
}
