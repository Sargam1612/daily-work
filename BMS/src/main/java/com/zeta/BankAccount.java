package com.zeta;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String name;
    private float balance;
    private final int accountNumber;
    private boolean hasLoan = false;

    private final List<Transaction> transactions = new ArrayList<>();

    public BankAccount(int accountNumber, float balance,String name) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public synchronized List<Transaction> getTransactions() {
        return transactions;
    }


    public synchronized void Deposit(float amount) {
        balance += amount;
        transactions.add(new Transaction(accountNumber, amount, "CREDIT"));
        System.out.println("Deposited: " + amount);
    }

    public synchronized void Withdraw(float amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction(accountNumber, amount, "DEBIT"));
            System.out.println("Withdrawn: " + amount);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

    public synchronized float loanSanction(float pAmount, int tenure) {
        if (hasLoan) throw new IllegalArgumentException("Loan already sanctioned");
        if (tenure >= 5) throw new IllegalArgumentException("Tenure should be less than 5 years");
        hasLoan = true;
        return pAmount * 7 * tenure / 100;
    }

    public synchronized float getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Name: "+ name+ " , Account No: " + accountNumber + ", Balance: " + balance;
    }



}
