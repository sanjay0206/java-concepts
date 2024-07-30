package com.corejava.java8.streams.employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreamEx {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, 500);
        Employee employee2 = new Employee(2, 1000);
        Employee employee3 = new Employee(3, 1500);
        Employee employee4 = new Employee(4, 2000);
        Employee employee5 = new Employee(5, 2500);
        Employee employee6 = new Employee(6, 3000);
        Employee employee7 = new Employee(7, 3500);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        // Get count of employees whose salary is greater than 2000
        long count = employees.stream().filter(employee -> employee.getSalary() > 2000).count();
        System.out.println(count);

        employees.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("======================================");
        employees.stream()
                .map(employee -> {
                    double pcnt = employee.getSalary() * 0.20;
                    employee.setSalary(employee.getSalary() + pcnt);
                    return employee;
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);

//        // Fetch top 3 salaried employees details?
//        List<Employee> top3SalEmps = employees.stream().sorted(((o1, o2) -> ((int) o2.getSalary() - (int) o1.getSalary())))
//                .limit(3)
//                .collect(Collectors.toList());
//        System.out.println(top3SalEmps);
//
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getSalary, Collections.reverseOrder()))
//                .limit(3)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        // Fetch all employees having salary less than 3rd highest salary
//        List<Employee> filteredEmps = employees.stream().sorted(((o1, o2) -> ((int) o2.getSalary() - (int) o1.getSalary())))
//                .skip(3)
//                .collect(Collectors.toList());
//        System.out.println(filteredEmps);
//
//        employees.stream()
//                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
//                .skip(3)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
    }
}
