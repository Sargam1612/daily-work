package com.zeta;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Bankaccount bankaccount = new Bankaccount(1000);
        Future future = executor.submit(new DepositTask(bankaccount,1000));
        Future future1 = executor.submit(new DepositTask(bankaccount,1000));
        try {
            System.out.println(future.get(10, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            if (e instanceof TimeoutException) {

            }
        }
        System.out.println(future.get());
        System.out.println(future1.get());
        Thread.sleep(3000);
        System.out.println(bankaccount.getBalance());;
    }
}