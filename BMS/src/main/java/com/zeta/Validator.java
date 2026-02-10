package com.zeta;

public class Validator {

    public static void check(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}
