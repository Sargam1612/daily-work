package com.zeta;

class Account{

    int AccountNumber;
    String Account_type;
    float balance;

    //constructor
    Account(int AccountNumber){
        this.AccountNumber=AccountNumber;
    }

    //copy constructor
    Account(Account a2){
        this.AccountNumber=AccountNumber;
    }
    public void setBalance(float balance){
        this.balance=balance;
    }
    public float getBalance(){
        return balance;
    }
    public void displayBalance(){
        System.out.println(this.balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Account account1 = new Account(123);
        Account account2 = new Account(999);
        account1.Account_type="Savings";
        account1.balance = 2000;
        account2.balance = 1000;
        account1.displayBalance();
        account2.displayBalance();

        Account a3 = new Account(account1);
        a3.displayBalance();;
    }
}
