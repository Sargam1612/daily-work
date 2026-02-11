package com.zeta;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String name;
    private float balance;
    private final int accountNumber;
    private boolean hasLoan = false;
    private final List<Transaction> transactions = new ArrayList<>();

    public BankAccount(int accountNumber, float balance, String name) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public synchronized void Deposit(float amount) {
        balance += amount;
        transactions.add(new Transaction(accountNumber, amount, "CREDIT"));
        System.out.println("Deposited: " + amount);
    }

    public synchronized void Withdraw(float amount) {
        if (balance < amount) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
        transactions.add(new Transaction(accountNumber, amount, "DEBIT"));
        System.out.println("Withdrawn: " + amount);
    }

    public synchronized float loanSanction(float pAmount, int tenure) {
        if (hasLoan) throw new IllegalArgumentException("Loan already taken");
        if (tenure >= 5) throw new IllegalArgumentException("Tenure must be < 5 years");
        hasLoan = true;
        return pAmount * 7 * tenure / 100;
    }

    public synchronized float getBalance() {
        return balance;
    }

    public synchronized List<Transaction> getTransactions() {
        return transactions;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", AccNo: " + accountNumber + ", Balance: " + balance;
    }
}
