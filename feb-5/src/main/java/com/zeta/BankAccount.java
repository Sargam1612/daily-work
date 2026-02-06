package com.zeta;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount);

        if (balance >= amount) {
            System.out.println("Approved for " + Thread.currentThread().getName());
            try { Thread.sleep(500); } catch (Exception e) {} // simulate processing
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal");
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
        }
    }

    int getBalance() {
        return balance;
    }
}
