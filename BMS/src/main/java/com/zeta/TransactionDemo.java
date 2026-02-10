package com.zeta;

public class TransactionDemo {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount(101, 1000);
        BankAccount acc2 = new BankAccount(102, 500);

        acc1.Withdraw(100);
        acc2.Deposit(100);

        System.out.println("\nTransactions for Account 101:");
        for (Transaction t : acc1.getTransactions()) {
            System.out.println(t);
        }

        System.out.println("Transactions for Account 102:");
        for (Transaction t : acc2.getTransactions()) {
            System.out.println(t);
        }

        System.out.println("Final Balances:");
        System.out.println("Acc 101: " + acc1.getBalance());
        System.out.println("Acc 102: " + acc2.getBalance());
    }
}
