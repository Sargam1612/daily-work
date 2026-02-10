package com.zeta;

public class BankTasks {

    // Lambda versions
//    public static Runnable WithdrawTask(BankAccount bankAccount, float amount) {
//        return () -> bankAccount.Withdraw(amount);
//    }
//
//    public static Runnable DepositTask(BankAccount bankAccount, float amount) {
//        return () -> bankAccount.Deposit(amount);
//    }

    public static class WithdrawTask implements Runnable {

        private final BankAccount bankAccount;
        private final float amount;

        public WithdrawTask(BankAccount bankAccount, float amount) {
            this.bankAccount = bankAccount;
            this.amount = amount;
        }

        @Override
        public void run() {
            String t = Thread.currentThread().getName();
            System.out.println(t + " trying to withdraw " + amount);
            bankAccount.Withdraw(amount);
        }
    }

    public static class DepositTask implements Runnable {

        private final BankAccount bankAccount;
        private final float amount;

        public DepositTask(BankAccount bankAccount, float amount) {
            this.bankAccount = bankAccount;
            this.amount = amount;
        }

        @Override
        public void run() {
            String t = Thread.currentThread().getName();
            System.out.println(t + " trying to deposit " + amount);
            bankAccount.Deposit(amount);
        }
    }

    public static class SanctionLoanTask implements Runnable {

        private final float pAmount;
        private final int tenure;
        private final BankAccount bankAccount;

        public SanctionLoanTask(float pAmount, int tenure, BankAccount bankAccount) {
            this.pAmount = pAmount;
            this.tenure = tenure;
            this.bankAccount = bankAccount;
        }

        @Override
        public void run() {
            String t = Thread.currentThread().getName();
            System.out.println(t + " processing loan...");
            float interest = bankAccount.loanSanction(pAmount, tenure);
            System.out.println("Loan sanctioned. Interest = " + interest);
        }
    }
}
