package com.zeta;

public class BankTasks {

    public static class WithdrawTask implements Runnable {
        private final BankAccount acc;
        private final float amount;

        public WithdrawTask(BankAccount acc, float amount) {
            this.acc = acc;
            this.amount = amount;
        }

        public void run() {
            String t = Thread.currentThread().getName();
            System.out.println(t + " attempting to withdraw " + amount);
            acc.Withdraw(amount);
            System.out.println(t + " successfully withdrew " + amount);
        }
    }

    public static class DepositTask implements Runnable {
        private final BankAccount acc;
        private final float amount;

        public DepositTask(BankAccount acc, float amount) {
            this.acc = acc;
            this.amount = amount;
        }

        public void run() {
            String t = Thread.currentThread().getName();
            System.out.println(t + " attempting to deposit " + amount);
            acc.Deposit(amount);
            System.out.println(t + " successfully deposited " + amount);
        }
    }

    public static class SanctionLoanTask implements Runnable {
        private final float p;
        private final int t;
        private final BankAccount acc;

        public SanctionLoanTask(float p, int t, BankAccount acc) {
            this.p = p;
            this.t = t;
            this.acc = acc;
        }

        public void run() {
            String tName = Thread.currentThread().getName();
            System.out.println(tName + " attempting to sanction loan");
            float interest = acc.loanSanction(p, t);
            System.out.println(tName + " loan sanctioned. Interest: " + interest);
        }
    }
}
