package com.zeta;

import java.time.LocalDateTime;

public class Transaction {

    private final int accountNumber;
    private final float amount;
    private final String type;
    private final LocalDateTime time;

    public Transaction(int accountNumber, float amount, String type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.time = LocalDateTime.now();
    }

    public String toString() {
        return "Account: " + accountNumber +
                ", Type: " + type +
                ", Amount: " + amount +
                ", Time: " + time;
    }
}
