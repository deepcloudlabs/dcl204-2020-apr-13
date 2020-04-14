package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Domain Expert
// Domain ==> >Entity< ==> Root Entity ==> Aggregate
public class Account extends Object {
    //region attributes ==> information hiding
    private final String iban; // ==> identity
    private double balance;
    //endregion

    //region constructors
    public Account(String iban) {
        this(iban, 0.0);
    }

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }
    //endregion

    //region getters
    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }
    //endregion

    //region business methods
    public boolean deposit(double amount) {
        // validation
        if (amount <= 0) return false;
        // business logic
        // this.balance = this.balance + amount ;
        this.balance += amount;
        return true;
    }

    // Ctrl + D : Duplicate
    // Alt + Shift + Up/Down Arrow
    // Ctrl + Alt + L
    public boolean withdraw(double amount) {
        // validation
        if (amount <= 0) return false; // Run-time exception
        // business rule
        if (amount > balance) return false; // Business Exception
        // business logic
        // this.balance = this.balance - amount ;
        this.balance -= amount;
        return true;
    }
    //endregion

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }
}