package com.corejava.java8.optionals.student;

import java.util.Optional;

public class OptionalClient {

    public static void main(String[] args) {
        Optional<Student> studentOptional = Optional.of(new Student("hamza", 22, "Morocco"));
        System.out.println(studentOptional);

        // Using Optional with a nullable return value
        Optional<Student> optionalStudent1 = Optional.ofNullable(getStudentWithName("hamza"));
        if (optionalStudent1.isPresent()) {
            System.out.println(optionalStudent1.get().getName());
        } else {
            System.out.println("Student is not present");
        }

        // Provide a default value if not present
        Student optionalStudent2 = Optional
                .ofNullable(getStudentWithName("haza"))
                .orElse(new Student("no one", 0, "Unknown"));
        System.out.println(optionalStudent2.getName());

        // Throw an exception if the student is not found
        Student optionalStudent3 = Optional
                .ofNullable(getStudentWithName("fs"))
                .orElseThrow(() -> new StudentNotFoundException("The student is not present"));
        System.out.println(optionalStudent3.getName());
    }

    public static Student getStudentWithName(String name) {
        // Simulating a database with two students: Ahmed and Hamza
        if (name.equals("hamza") || name.equals("ahmed")) {
            return new Student(name, 22, "Morocco");
        } else {
            return null;
        }
    }
}

/*
Optional[Student{name='hamza', age=22, country='Morocco'}]
hamza
no one
Exception in thread "main" com.corejava.java8.optionals.student.StudentNotFoundException: The student is not present
	at com.corejava.java8.optionals.student.OptionalClient.lambda$main$0(OptionalClient.java:28)
	at java.util.Optional.orElseThrow(Optional.java:290)
	at com.corejava.java8.optionals.student.OptionalClient.main(OptionalClient.java:28)
*/