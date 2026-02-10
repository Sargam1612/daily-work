package com.zeta;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.zeta.BankTasks.DepositTask;
import static com.zeta.BankTasks.WithdrawTask;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Multithreaded Banking App.");

        int accountNumber;

        while (true) {
            try {
                System.out.println("Enter bank Account number: ");
                String accInput = sc.next();
                AccountValidator.checkNumeric(accInput);
                accountNumber = Integer.parseInt(accInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }

        System.out.print("Enter Initial Balance: ");
        float balance = sc.nextFloat();
        BankAccount bankaccount = new BankAccount(accountNumber, balance);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            System.out.println("\nWhat do you want to perform?");
            System.out.println("1. Add Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Parallel Withdrawals");
            System.out.println("5. Apply for Loan");
            System.out.println("6. Show Transaction History");
            System.out.println("7. Exit");

            int x = sc.nextInt();

            try {
                switch (x) {
                    case 1:
                        System.out.print("Enter Amount to deposit: ");
                        float amount = sc.nextFloat();
                        Validator.check(amount);
                        executor.execute(new DepositTask(bankaccount, amount));
                        break;

                    case 2:
                        System.out.print("Enter Amount to withdraw: ");
                        amount = sc.nextFloat();
                        Validator.check(amount);
                        executor.execute(new WithdrawTask(bankaccount, amount));
                        break;

                    case 3:
                        System.out.println("Balance: " + bankaccount.getBalance());
                        break;

                    case 4:
                        float half = bankaccount.getBalance() / 2;
                        System.out.println("Parallel withdrawals of: " + half);
                        executor.execute(new WithdrawTask(bankaccount, half));
                        executor.execute(new WithdrawTask(bankaccount, half));
                        break;

                    case 5:
                        System.out.print("Enter Principal Amount: ");
                        float p = sc.nextFloat();
                        System.out.print("Enter Tenure (years): ");
                        int t = sc.nextInt();

                        executor.execute(new BankTasks.SanctionLoanTask(p, t, bankaccount));
                        break;
                    case 6:
                        System.out.println("Transaction History for Account " + bankaccount.getAccountNumber() + ":");
                        if (bankaccount.getTransactions().isEmpty()) {
                            System.out.println("No transactions yet.");
                        } else {
                            for (Transaction T : bankaccount.getTransactions()) {
                                System.out.println(T);
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Shutting app down.");
                        executor.shutdown();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
