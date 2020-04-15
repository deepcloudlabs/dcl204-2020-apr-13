package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Domain Expert
// Domain ==> >Entity< ==> Root Entity ==> Aggregate
public class Account extends Object /* implicit */ {
    //region attributes ==> information hiding
    final String iban; // ==> identity // default permission, package private
    protected double balance;
    private AccountStatus status;
    //endregion

    //region constructors: overloading
    public Account(final String iban) {
        this(iban, 0.0);
    }

    public Account(final String iban, final double balance) {
        super(); // implicit
        this.iban = iban;
        this.balance = balance;
    }
    //endregion

    //region getters

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }
    //endregion

    //region business methods
    public boolean deposit(final double amount) {
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
    public boolean withdraw(final double amount) {
        System.err.println("Account::withdraw");
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
