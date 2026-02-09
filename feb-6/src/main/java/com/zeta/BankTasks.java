package com.zeta;

import java.util.function.Supplier;

public class BankTasks {


    Supplier<String> threadName = () -> Thread.currentThread().getName();
//    public class WithdrawTask implements Runnable{
//        private final BankAccount bankAccount;
//        private final float amount;
//
//        public WithdrawTask(BankAccount bankAccount,float amount) {
//            this.bankAccount = bankAccount;
//            this.amount = amount;
//        }
//
//        @Override
//        public void run() {
//            String thread = Thread.currentThread().getName();
//            System.out.println(thread+" attempting to withdraw "+amount);
//            try {
//                bankAccount.Withdraw(amount);
//                System.out.println(thread+" completed withdrawal. "+amount);
//            }catch (IllegalArgumentException e){
//                e.printStackTrace();
//            }
//
//        }
//    }

    public static Runnable WithdrawTask(BankAccount bankAccount, float amount) { return () -> {
            String thread = Thread.currentThread().getName();
            System.out.println(thread + " attempting to withdraw " + amount);
            try {
                bankAccount.Withdraw(amount);
                System.out.println(thread + " completed withdrawal. " + amount);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        };
    }
    public static Runnable DepositTask(BankAccount bankAccount, float amount) { return () -> {
            String thread = Thread.currentThread().getName();
            System.out.println(thread + " attempting to deposit of $" + amount);
            try {
                bankAccount.Deposit(amount);
                System.out.println(thread + " completed deposit of $" + amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }


//    public class DepositTask implements Runnable{
//        private final BankAccount bankAccount;
//        private final float amount;
//        public DepositTask(BankAccount bankAccount,float amount) {
//            this.bankAccount = bankAccount;
//            this.amount = amount;
//        }
//
//        @Override
//        public void run() {
//            String thread = Thread.currentThread().getName();
//            System.out.println(thread+" attempting to deposit of $"+amount);
//            try{
//                bankAccount.Deposit(amount);
//                System.out.println(thread+" completed deposit of &"+amount);
//            }catch(InterruptedException e){
//
//            }
//
//        }
//    }

    public static class sanctionLoan implements Runnable{

        public float pAmount;
        public int tenure ;
        private final BankAccount bankAccount;

        public sanctionLoan(float pAmount, int tenure, BankAccount bankAccount) {
            this.pAmount=pAmount;
            this.tenure=tenure;
            this.bankAccount = bankAccount;
        }

        @Override
        public void run() {
            String thread = Thread.currentThread().getName();
            System.out.println(thread+" sanctioning loan for $"+pAmount);
            try{
                float interestAmount = bankAccount.loanSanction(pAmount,tenure);
                System.out.println(thread+" sanctioned loan for $"+pAmount);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

    }


}
