package com.zeta;

public class Loan {

    public static boolean sanction(float principalAmount, int tenure, BankAccount bankAccount) {
        try {
            bankAccount.loanSanction(principalAmount, tenure);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
