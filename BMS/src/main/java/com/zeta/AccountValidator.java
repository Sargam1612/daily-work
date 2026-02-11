package com.zeta;

public class AccountValidator {

    public static void checkNumeric(String accInput) {
        if (accInput == null || accInput.isEmpty())
            throw new IllegalArgumentException("Account number cannot be empty");

        for (char c : accInput.toCharArray()) {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("Account number must be numeric");
        }
    }
}
