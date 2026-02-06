package com.zeta;

public class Bankaccount {
    private  int balance;

    public Bankaccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance+=amount;
    }
}
