package com.zeta;
import com.zeta.BankTasks;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Multithreaded Banking App.");
        System.out.print("Enter Initial Balance: ");
        float balance = sc.nextInt();
        BankAccount bankaccount = new BankAccount(balance);
        BankTasks bankTask = new BankTasks();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        while(true){
            System.out.println("What do you want to perform? ");
            System.out.println("1.Add Money");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Check balance");
            System.out.println("4.parallel Withdrawals");
            System.out.println("5.Exit");

            int x = sc.nextInt();

            switch (x){
                case 1:
                    System.out.println("Enter Amount to deposit: ");
                    float amount = sc.nextFloat();
                    executor.execute(bankTask.new DepositTask(bankaccount,amount));
                    System.out.println(amount + " rupees deposited.");
                    break;
                case 2:
                    System.out.println("Enter Amount to Withdraw: ");
                    amount = sc.nextFloat();
                    executor.execute(bankTask.new WithdrawTask(bankaccount,amount));
                    System.out.println(amount + " rupees withdrawn.");
                    break;
                case 3:
                    System.out.println("Your balance is : "+ bankaccount.getBalance()); break;
                case 4:
                    System.out.println("Parallelizing withdrawals on half balance : "+ balance/2);
                    executor.execute(bankTask.new WithdrawTask(bankaccount,balance/2));
                    executor.execute(bankTask.new WithdrawTask(bankaccount,balance/2));
                    break;
                case 5:
                    System.out.println("Shutting app down.");
                    executor.shutdown();
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");

            }

        }
    }
}