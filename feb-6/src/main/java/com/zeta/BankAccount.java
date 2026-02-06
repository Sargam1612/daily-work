package com.zeta;

public class BankAccount{
    float balance;
    public BankAccount(float balance) {
        this.balance = balance;
    }

    public synchronized void Deposit(float amount) throws InterruptedException {
        if(balance>=amount){
            balance+=amount;
        }
    }

    public synchronized void Withdraw(float amount) throws InterruptedException {
        if(balance>=amount){
            balance-=amount;
        }
    }

    public synchronized float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
