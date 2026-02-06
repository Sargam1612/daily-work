package com.zeta;

public class Loan {
    private float interestRate = 7;
    private final float principalAmount;
    private final int tenure;
    private BankAccount bankAccount;
    public Loan(float principalAmount, int tenure,BankAccount bankAccount) {
        this.principalAmount = principalAmount;
        this.tenure = tenure;
    }
    public static boolean sanction(float principalAmount, int tenure,BankAccount bankAccount){
        try{
            new BankTasks.sanctionLoan(principalAmount,tenure,bankAccount);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;

    }
}
