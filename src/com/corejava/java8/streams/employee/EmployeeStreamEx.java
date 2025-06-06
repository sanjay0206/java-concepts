package com.corejava.java8.streams.employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
        employees.forEach(System.out::println);

        // Get count of employees whose salary is greater than 2000
        long count = employees.stream().filter(employee -> employee.getSalary() > 2000).count();
        System.out.println("Count of employees whose salary is greater than 2000: " + count);

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

        // Fetch all employees having salary less than 3rd highest salary
        List<Employee> filteredEmps = employees.stream().sorted(((o1, o2) -> ((int) o2.getSalary() - (int) o1.getSalary())))
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Employees having salary less than 3rd highest salary: " + filteredEmps);

        // Find Employee with max salary
        Employee maxSalaryEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println("Employee with max salary: " + maxSalaryEmployee);

        // Find Employee with min salary
        Employee minSalaryEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        System.out.println("Employee with min salary: " + minSalaryEmployee);

        // Group employees by salary range (e.g., <2000, >=2000)
        Map<String, List<Employee>> groupedBySalary =
                employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.getSalary() < 2000 ? "Below 2000" : "2000 and above"));;
        groupedBySalary.forEach((k, v) -> System.out.println(k + " -> " + v));

    }
}
