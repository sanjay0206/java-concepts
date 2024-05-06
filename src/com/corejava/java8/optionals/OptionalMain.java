package com.corejava.java8.optionals;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
       /* Student student = getStudentWithName("hmza");
        System.out.println(student.getName());*/
        /*Exception in thread "main" java.lang.NullPointerException
	    at com.corejava.java8.optionals.OptionalMain.main(OptionalMain.java:8) */

        Optional<Student> studentOptional = Optional.of(new Student("hamza" , 22 , "Morocco"));
        System.out.println(studentOptional);

        // 1st
        Optional<Student> optionalStudent1 = Optional.ofNullable(getStudentWithName("hamza"));
        if (optionalStudent1.isPresent()) {
            System.out.println(optionalStudent1.get().getName());
        } else {
            System.out.println("Student is not present");
        }

        // 2nd
        Student optionalStudent2 = Optional
                .ofNullable(getStudentWithName("haza"))
                .orElse(new Student("no one", 0, "Unknown"));
        System.out.println(optionalStudent2.getName());

        // 3rd
        Student optionalStudent3 = Optional
                .ofNullable(getStudentWithName("fs"))
                .orElseThrow(()-> new StudentNotFoundException("the Student is not Present"));
        System.out.println(optionalStudent3.getName());

    }

    public  static Student  getStudentWithName(String name){
        // lets suppose that our database contain only 2 students ahmed and hamza .
        if (name.equals("hamza") || name.equals("ahmed")) {
            return new Student(name , 22 , "Morocco");
        } else {
            return null ;
        }
    }
}
/*
op:

Optional[Student{name='hamza', age=22, country='Morocco'}]
hamza
no one
Exception in thread "main" com.corejava.java8.optionals.StudentNotFoundException: the Student is not Present
at com.corejava.java8.optionals.OptionalMain.lambda$main$0(OptionalMain.java:32)
at java.util.Optional.orElseThrow(Optional.java:290)
at com.corejava.java8.optionals.OptionalMain.main(OptionalMain.java:32)
*/
