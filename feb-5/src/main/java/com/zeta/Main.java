package com.zeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount(100);

        Thread t1 = new Thread(() -> acc.withdraw(80), "T1");
        Thread t2 = new Thread(() -> acc.withdraw(80), "T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final balance = " + acc.getBalance());
        /*
        Counter counter = new Counter();
        Thread t1 = new Worker(counter);
        t1.start();
        System.out.println(counter.getValue());
        Thread t2 = new Worker(counter);
        System.out.println(counter.getValue());
        t2.start();
        System.out.println(counter.getValue());

        /*Worker worker0 = new Worker("staff1");
        worker0.start();
        try {
            worker0.wait(1000);
        }catch(Exception e){
        }
        Worker worker1= new Worker("staff2");

        worker1.start();
        worker1.yield();*/
    }

}