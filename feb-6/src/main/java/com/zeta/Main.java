package com.zeta;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Multithreaded Banking App.");
        System.out.println("Enter bank Account number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter Initial Balance: ");
        float balance = sc.nextFloat();
        BankAccount bankaccount= new BankAccount(accountNumber,balance);

        BankTasks bankTask = new BankTasks();

        ExecutorService executor = Executors.newFixedThreadPool(3);
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
                        Validator.check(amount);
                        executor.execute(bankTask.new DepositTask(bankaccount, amount));
                        System.out.println(amount + " rupees deposited.");
                        break;
                    case 2:
                        System.out.println("Enter Amount to Withdraw: ");
                        amount = sc.nextFloat();
                        Validator.check(amount);
                        executor.execute(bankTask.new WithdrawTask(bankaccount, amount));
                        System.out.println(amount + " rupees withdrawn.");
                        break;
                    case 3:
                        System.out.println("Your balance is : " + bankaccount.getBalance());
                        break;
                    case 4:
                        System.out.println("Parallelizing withdrawals on half balance : " + bankaccount.getBalance() / 2);
                        executor.execute(bankTask.new WithdrawTask(bankaccount, bankaccount.getBalance() / 2));
                        executor.execute(bankTask.new WithdrawTask(bankaccount, bankaccount.getBalance() / 2));
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