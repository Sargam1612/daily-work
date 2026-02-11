package com.zeta;

import java.util.HashMap;
import java.util.Map;
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
        float balance;
        int key = 1;
        Map<Integer,BankAccount> BankAccountsMap = new HashMap<>();
        BankAccount bankaccount=null;

        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            System.out.println("\nWhat do you want to perform?");
            System.out.println("1. Create account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Add Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Parallel Withdrawals");
            System.out.println("7. Apply for Loan");
            System.out.println("8. Show Transaction History");
            System.out.println("9. Exit");

            System.out.print("\n\nENTER YOUR CHOICE: ");

            int x = sc.nextInt();

            try {
                switch (x) {
                    case 1:
                        try {
                            System.out.println("Let's Create Your Account!");
                            System.out.println("Enter your Name: ");
                            String name = sc.next();
                            System.out.println("Enter bank Account number: ");
                            String accInput = sc.next();
                            AccountValidator.checkNumeric(accInput);
                            accountNumber = Integer.parseInt(accInput);
                            System.out.print("Enter Initial Balance: ");
                            balance = sc.nextFloat();
                            bankaccount = new BankAccount(accountNumber, balance,name);
                            BankAccountsMap.put(key++,bankaccount);
                            System.out.println("Your Account has been Created!");
                            System.out.println(bankaccount);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage() + " Please try again.");
                        }

                    case 2:
                        System.out.println("Existing Accounts are:");
                        for(int i = 1; i<= BankAccountsMap.size(); i++) {
                            System.out.println(BankAccountsMap.get(i));
                        }
                        break;

                    case 3:
                        System.out.println("Enter Account Number: ");
                        String accInput = sc.next();
                        AccountValidator.checkNumeric(accInput);
                        accountNumber = Integer.parseInt(accInput);
                        System.out.print("Enter Amount to deposit: ");
                        float amount = sc.nextFloat();
                        Validator.check(amount);

                        executor.execute(new DepositTask(bankaccount, amount));
                        break;

                    case 4:
                        System.out.print("Enter Amount to withdraw: ");
                        amount = sc.nextFloat();
                        Validator.check(amount);
                        executor.execute(new WithdrawTask(bankaccount, amount));
                        break;

                    case 5:
                        System.out.println("Balance: " + bankaccount.getBalance());
                        break;

                    case 6:
                        float half = bankaccount.getBalance() / 2;
                        System.out.println("Parallel withdrawals of: " + half);
                        executor.execute(new WithdrawTask(bankaccount, half));
                        executor.execute(new WithdrawTask(bankaccount, half));
                        break;

                    case 7:
                        System.out.print("Enter Principal Amount: ");
                        float p = sc.nextFloat();
                        System.out.print("Enter Tenure (years): ");
                        int t = sc.nextInt();

                        executor.execute(new BankTasks.SanctionLoanTask(p, t, bankaccount));
                        break;
                    case 8:
                        System.out.println("Transaction History for Account " + bankaccount.getAccountNumber() + ":");
                        if (bankaccount.getTransactions().isEmpty()) {
                            System.out.println("No transactions yet.");
                        } else {
                            for (Transaction T : bankaccount.getTransactions()) {
                                System.out.println(T);
                            }
                        }
                        break;
                    case 9:
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
