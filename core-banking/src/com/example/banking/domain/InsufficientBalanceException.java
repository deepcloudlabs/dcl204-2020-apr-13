package com.example.banking.domain;

// Best Practice: Immutable, Value Object
// Business Exception
public class InsufficientBalanceException extends Exception {
    private final double deficit;

    public InsufficientBalanceException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public final double getDeficit() {
        return deficit;
    }
}
