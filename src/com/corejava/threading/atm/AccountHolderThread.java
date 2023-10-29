package com.corejava.threading.atm;

public class AccountHolderThread implements Runnable {

    public Account account;
    public int maxTransactionLimit;
    public int withdrawalAmount;
    public int transactionCount = 0;

    public AccountHolderThread(Account account, int withdrawalAmount, int maxTransactionLimit) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
        this.maxTransactionLimit = maxTransactionLimit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxTransactionLimit; i++) {
            makeWithdrawal(withdrawalAmount);
        }
    }

    public synchronized void makeWithdrawal(int withdrawalAmount) {
        System.out.println("######## Transaction-" + ++transactionCount + " has started ########");
        if (account.getBalance() >= withdrawalAmount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw $" + withdrawalAmount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
            account.withdrawAmount(withdrawalAmount);
            System.out.println(Thread.currentThread().getName() + " completes withdrawal of $" + withdrawalAmount + "\n");
        } else {
            System.out.println("Sorry " + Thread.currentThread().getName() + "! Insufficient balance for withdrawal." +
                    "\nCurrent a/c balance: " + account.getBalance() +
                    "\nWithdrawal amount: " + withdrawalAmount +
                    "\n"
            );
        }
    }

}
