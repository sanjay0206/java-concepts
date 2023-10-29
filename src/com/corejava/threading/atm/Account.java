package com.corejava.threading.atm;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdrawAmount(int withdrawalAmount) {
        balance = balance - withdrawalAmount;
    }
}
