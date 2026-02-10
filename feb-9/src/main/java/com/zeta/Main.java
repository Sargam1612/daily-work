package com.zeta;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random r = new Random();
        Account[] accounts = new Account[1000000];
        for(int i=0;i<accounts.length;i++){
            int balance = 1000 + r.nextInt(9001); // 1000 to 10000
            accounts[i] = new Account(balance);
        }


       // for (Account a : accounts) {
        //    System.out.println(a.getBalance());
       // }

        //int[] array1 = {account1.getBalance(),account2.getBalance()};
        //int[] array = {1,2,3,4,5,6,34,46,74,33,5,77,8,9};
        ForkJoinPool  f = new ForkJoinPool();
        long start = System.currentTimeMillis();
        System.out.println("Starts at : " +System.currentTimeMillis());
        int result = f.invoke(new SumTask(accounts,0,accounts.length));
        System.out.println("Time taken: " + (System.currentTimeMillis() - start));
        System.out.println("Sum = "+ result);

    }
}