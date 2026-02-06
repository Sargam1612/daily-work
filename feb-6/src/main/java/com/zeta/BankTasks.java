package com.zeta;

public class BankTasks {

    public class WithdrawTask implements Runnable{
        private final BankAccount bankAccount;
        private final float amount;

        public WithdrawTask(BankAccount bankAccount,float amount) {
            this.bankAccount = bankAccount;
            this.amount = amount;
        }

        @Override
        public void run() {
            String thread = Thread.currentThread().getName();
            System.out.println(thread+" attempting to withdraw "+amount);
            try {
                bankAccount.Withdraw(amount);
            }catch (InterruptedException e){

            }
            System.out.println(thread+" completed withdrawal. "+amount);
        }
    }



    public class DepositTask implements Runnable{
        private final BankAccount bankAccount;
        private final float amount;
        public DepositTask(BankAccount bankAccount,float amount) {
            this.bankAccount = bankAccount;
            this.amount = amount;
        }

        @Override
        public void run() {
            String thread = Thread.currentThread().getName();
            System.out.println(thread+" attempting to deposit "+amount);
            try{
                  bankAccount.Deposit(amount);
            }catch(InterruptedException e){

            }
            System.out.println(thread+" completed deposit. "+amount);
        }
    }


}
