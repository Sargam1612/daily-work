package com.zeta;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.zeta.BankTasks.DepositTask;
import static com.zeta.BankTasks.WithdrawTask;

public class Main {

    public static void main(String[] args) {
        Map<Integer, BankAccount> accounts = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        BankAccount bankAccount=null;
        System.out.println("\n\nLOG-IN in Banking App\n ");
        while(true){
            try{
                   bankAccount = getAccount(accounts);
            }
            catch (IllegalArgumentException e){
                     e.getMessage();
            }
            break;
        }


        BankAccount acc=null;
        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            System.out.println("\n========Welcome to Multithreaded Banking App==========");
            System.out.println("1. Create account");
            System.out.println("2. Show all accounts");
            System.out.println("3. Add Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Parallel Withdrawals");
            System.out.println("7. Apply for Loan");
            System.out.println("8. Show Transaction History");
            System.out.println("9. Exit");

            System.out.print("\nENTER YOUR CHOICE: ");
            int x = sc.nextInt();

            try {
                switch (x) {

                    case 1: {
                        System.out.print("Enter your Name: ");
                        String name = sc.next();

                        System.out.print("Enter bank Account number: ");
                        String accInput = sc.next();
                        AccountValidator.checkNumeric(accInput);
                        int accNo = Integer.parseInt(accInput);

                        if (accounts.containsKey(accNo)) {
                            System.out.println("Account already exists.");
                            break;
                        }

                        System.out.print("Enter Initial Balance: ");
                        float bal = sc.nextFloat();

                        acc = new BankAccount(accNo, bal, name);
                        accounts.put(accNo, acc);
                        bankAccount=acc;

                        System.out.println("Account Created Successfully");
                        System.out.println(acc);
                        break;
                    }

                    case 2: {
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts found.");
                        } else {
                            for (BankAccount b : accounts.values()) {
                                System.out.println(b);
                            }
                        }
                        break;
                    }

                    case 3: {
                        System.out.print("Enter amount to deposit: ");
                        float amt = sc.nextFloat();
                        Validator.check(amt);
                        executor.execute(new DepositTask(acc, amt));
                        break;
                    }

                    case 4: {
                        System.out.print("Enter amount to withdraw: ");
                        float amt = sc.nextFloat();
                        Validator.check(amt);
                        executor.execute(new WithdrawTask(acc, amt));
                        break;
                    }

                    case 5: {
                        System.out.println("Balance: " + acc.getBalance());
                        break;
                    }

                    case 6: {
                        float half = acc.getBalance() / 2;
                        executor.execute(new WithdrawTask(acc, half));
                        executor.execute(new WithdrawTask(acc, half));
                        break;
                    }

                    case 7: {
                        System.out.print("Enter principal amount: ");
                        float p = sc.nextFloat();
                        System.out.print("Enter tenure: ");
                        int t = sc.nextInt();
                        executor.execute(new BankTasks.SanctionLoanTask(p, t, acc));
                        break;
                    }

                    case 8: {
                        if (acc.getTransactions().isEmpty()) {
                            System.out.println("No transactions yet.");
                        } else {
                            for (Transaction t : acc.getTransactions()) {
                                System.out.println(t);
                            }
                        }
                        break;
                    }

                    case 9:
                        executor.shutdown();
                        sc.close();
                        System.out.println("App closed.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static BankAccount getAccount(Map<Integer, BankAccount> accounts) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accInput = sc.next();
        AccountValidator.checkNumeric(accInput);
        int accNo = Integer.parseInt(accInput);
        BankAccount acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
        }
        return acc;
    }
}
