package com.zeta;

import java.lang.invoke.CallSite;
import java.util.concurrent.Callable;

public class DepositTask implements Callable {
    private final int amount;
    private final Bankaccount bankaccount;

    public DepositTask(Bankaccount bankaccount,int amount) {
        this.bankaccount = bankaccount;
        this.amount = amount;
    }


    @Override
    public Object call() throws Exception {
        Thread.sleep((long)Math.random()*1000);
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " depositing ?" + amount);
        if(true)
            throw new RuntimeException("something went wrong!!");
        bankaccount.deposit(amount);
        System.out.println(thread + " completed deposit of ?" + amount);
        return bankaccount.getBalance();
    }
}
