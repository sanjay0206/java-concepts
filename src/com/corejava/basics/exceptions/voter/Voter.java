package com.corejava.basics.exceptions.voter;

import java.util.Scanner;

public class Voter {

    private static void isEligibleToVote(int age) throws InvalidAgeException {
        if (age > 18) {
            System.out.println("Hey! you are eligible to vote.");
        } else {
            throw new InvalidAgeException("Sorry! your age should be above 18 to vote.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of test cases: ");
        int tc = sc.nextInt();
        while (tc-- > 0) {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            try {
                isEligibleToVote(age);
            } catch (InvalidAgeException e) {
                System.out.println("Exception occurred: " + e.getMessage());
            } finally {
                System.out.println("Age validation is done!");
            }
        }

    }
}

/*
Enter the no. of test cases: 2
Enter your age: 16
Exception occurred: Sorry! your age should be above 18 to vote.
Age validation is done!
Enter your age: 19
Hey! you are eligible to vote.
Age validation is done!
*/