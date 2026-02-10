package com.zeta;

public class AccountValidator {

    public static void checkNumeric(String accInput) {
        if (accInput == null || accInput.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }

        for (int i = 0; i < accInput.length(); i++) {
            if (!Character.isDigit(accInput.charAt(i))) {
                throw new IllegalArgumentException("Account number must contain only digits");
            }
        }
    }
}
