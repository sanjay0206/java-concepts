package com.corejava.threading.atm;

import java.util.Scanner;

public class ATMMain {

    public static void main(String[] args) {
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total account balance: $");
        int balance = sc.nextInt();
        account.setBalance(balance);
        System.out.println("Your account balance is now $" + account.getBalance());

        System.out.print("Enter the withdrawal amount: ");
        int withdrawalAmount = sc.nextInt();

        System.out.print("Enter the maximum transaction limit per thread: ");
        int maxTransactionLimit = sc.nextInt();

        AccountHolderThread accountHolder = new AccountHolderThread(account, withdrawalAmount, maxTransactionLimit);
        System.out.println();
        Thread t1 = new Thread(accountHolder);
        Thread t2 = new Thread(accountHolder);

        t1.setName("Jack-t1");
        t2.setName("Alice-t2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {
        }
        // if t1 and t2 are not joined it will print this statement from main thread before completing execution o t1 and t2.
        System.out.println("Available a/c balance after thread execution is $" + account.getBalance());
    }
}
/*
Enter the total account balance: $5000
Your account balance is now $5000
Enter the withdrawal amount: 1500
Enter the maximum transaction limit per thread: 2

######## Transaction-1 has started ########
Jack-t1 is going to withdraw $1500
Jack-t1 completes withdrawal of $1500

######## Transaction-2 has started ########
Jack-t1 is going to withdraw $1500
Jack-t1 completes withdrawal of $1500

######## Transaction-3 has started ########
Alice-t2 is going to withdraw $1500
Alice-t2 completes withdrawal of $1500

######## Transaction-4 has started ########
Sorry Alice-t2! Insufficient balance for withdrawal.
Current a/c balance: 500
Withdrawal amount: 1500

Available a/c balance after thread execution is $500
*/