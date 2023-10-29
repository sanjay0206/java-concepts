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
                e.printStackTrace();
            } finally {
                System.out.println("Age validation is done!");
            }
        }

    }
}

/*
Enter the no. of test cases: 2
Enter your age: 16
Age validation is done!
com.corejava.basics.exceptions.voter.InvalidAgeException: Sorry! your age should be above 18 to vote.
	at com.corejava.basics.exceptions.voter.Voter.isEligibleToVote(Voter.java:11)
	at com.corejava.basics.exceptions.voter.Voter.main(Voter.java:23)
Enter your age: 23
Hey! you are eligible to vote.
Age validation is done!
*/