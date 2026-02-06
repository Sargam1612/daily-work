package com.zeta;

public class BankAccount{
    float balance;
    int AccountNumber;
    public BankAccount(int AccountNumber,float balance) {
        this.balance = balance;
        this.AccountNumber=AccountNumber;
    }

    public synchronized void Deposit(float amount) throws InterruptedException {
        if(balance>=amount){
            balance+=amount;
        }
    }

    public synchronized void Withdraw(float amount) throws IllegalArgumentException {
        if(balance>=amount){
            balance-=amount;
        }
        else  throw new IllegalArgumentException();
    }

    public synchronized float loanSanction(float pAmount,int tenure) throws IllegalArgumentException{
        if(tenure<5){
            float interestAmount = pAmount*7*tenure/100;
            return interestAmount;
        }
        else throw new IllegalArgumentException("Tenure should be less than 5 years.");
    }

    public synchronized float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
