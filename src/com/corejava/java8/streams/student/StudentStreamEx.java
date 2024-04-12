package com.corejava.java8.streams.student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamEx {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Collections.singletonList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());

        // count students name start with 'a'
        long c = studentList.stream()
                .filter(student -> student.getFirstName().toLowerCase().startsWith("a"))
                .count();
        System.out.println(c);

        // printing duplicates without using Set and List
        studentList.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 1. Find the list of students  whose rank is in between 50 and 100
        System.out.println(" 1. Find the list of students  whose rank is in between 50 and 100");
        studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 2. Find the students who stays in Karnataka and sort them by their names
        System.out.println("2. Find the students who stays in Karnataka and sort them by their names");
        studentList.stream().filter(student -> student.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName))
                //   .sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 3. Find all unique departments names
        System.out.println("3. Find all unique departments names");
        studentList.stream().map(Student::getDept)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 4. Display all contact unique numbers
        System.out.println("4. Display all unique contact numbers");
        studentList.stream().flatMap(student -> student.getContacts().stream())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // map -> one to one  flatMap -> one to many
        // 5. Group students by Department Names
        System.out.println("5. Group students by Department Names");
        studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " -> " + value));

        // 6. Find the average age of male and female students
        System.out.println("6. Find the average age of male and female students");
        studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)))
                .forEach((key, value) -> System.out.println(key + " -> " + value));

        // 7. Find the highest rank in each department
        System.out.println("7. Find the highest rank in each department");
        studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getRank))))
                .forEach((key, value) -> System.out.println("Department: " + key + ", Top Student: " + value.orElse(null)));

        // 8. Find student who has second rank
        System.out.println("8. Find student who has second rank");
        studentList.stream()
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
