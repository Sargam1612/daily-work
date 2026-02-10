package com.zeta;

public class LoanExists {
    private static float principalAmount;
    static int tenure;
    private BankAccount bankaccount;
    public LoanExists(float principalAmount, int tenure, BankAccount bankaccount) {
        this.principalAmount = principalAmount;
        this.tenure = tenure;
        this.bankaccount = bankaccount;
    }

    public static void check(BankAccount bankAccount){
        if(Loan.sanction(principalAmount, tenure, bankAccount)){
            throw new IllegalArgumentException("Loan Already Sanctioned!");
        }
    }
}
