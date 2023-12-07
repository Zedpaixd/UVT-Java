package org.example;

public class BankClient extends Thread {
    private final BankAccount account;
    private final double amount;
    private final boolean deposit;

    public BankClient(BankAccount account, double amount, boolean deposit) {
        this.account = account;
        this.amount = amount;
        this.deposit = deposit;
    }

    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
