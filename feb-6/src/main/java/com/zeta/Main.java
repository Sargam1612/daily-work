package com.zeta;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;

import static com.zeta.BankTasks.DepositTask;
import static com.zeta.BankTasks.WithdrawTask;


public class Main {

    static DoubleConsumer Validator = a -> {
        if (a <= 0) throw new IllegalArgumentException("Amount must be greater than 0");
    };
    static Consumer<String> log = msg -> System.out.println("[LOG] " + msg);

    Predicate<Float> isValidAmount = a -> a > 0;



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Multithreaded Banking App.");
        System.out.println("Enter bank Account number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        float balance = sc.nextFloat();
        BankAccount bankaccount= new BankAccount(accountNumber,balance);

        BankTasks bankTask = new BankTasks();

        //ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor = Executors.newFixedThreadPool(3, r -> new Thread(r));

        // Validator v = new Validator(); make the method static
        while(true){
            System.out.println("What do you want to perform? ");
            System.out.println("1.Add Money");
            System.out.println("2.Withdraw Money");
            System.out.println("3.Check balance");
            System.out.println("4.parallel Withdrawals");
            System.out.println("5.Apply for loan.");
            System.out.println("5.Exit");

            int x = sc.nextInt();

            try {

                switch (x) {
                    case 1:
                        System.out.println("Enter Amount to deposit: ");
                        float amount = sc.nextFloat();
                        Validator.accept(amount);
                        executor.execute(DepositTask(bankaccount, amount));
                        System.out.println(amount + " rupees deposited.");
                        break;
                    case 2:
                        System.out.println("Enter Amount to Withdraw: ");
                        amount = sc.nextFloat();
                        Validator.accept(amount);
                        executor.execute(WithdrawTask(bankaccount, amount));
                        System.out.println(amount + " rupees withdrawn.");
                        break;
                    case 3:
                        log.accept("Balance: " + bankaccount.getBalance());
                        break;
                    case 4:
                        System.out.println("Parallelizing withdrawals on half balance : " + bankaccount.getBalance() / 2);
                        executor.execute(WithdrawTask(bankaccount, bankaccount.getBalance() / 2));
                        executor.execute(WithdrawTask(bankaccount, bankaccount.getBalance() / 2));
                        break;
                    case 5:
                        System.out.print("Enter Principal Amount :");
                        float principalAmount = sc.nextFloat();
                        System.out.print("Enter Tenure(in years) :");
                        int tenure = sc.nextInt();
                        //LoanExists.check(bankaccount);

                        Loan loan= new Loan(principalAmount,tenure,bankaccount);
                        loan.sanction(principalAmount,tenure,bankaccount);
                        float interestAmount = bankaccount.loanSanction(principalAmount,tenure);
                        System.out.println("Loan Sanctioned Successfully! Your interest amount (as per 7% rate) is: "+ interestAmount);
                        break;
                    case 6:
                        System.out.println("Shutting app down.");
                        executor.shutdown();
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }


        }
    }
}