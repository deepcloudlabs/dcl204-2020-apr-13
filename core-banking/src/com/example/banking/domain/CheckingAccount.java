package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Account : super class/base class
// CheckingAccount : sub-class / derived class
// Overloading vs Overriding
// Overloading : Same class, same methods with different signature
// Overriding : Inheritance class, same method with same signature
// Access modifiers : public, private, protected, <default>
public class CheckingAccount extends Account {
    private double overdraftAmount;

    public CheckingAccount(final String iban,final double balance) {
        this(iban, balance, 1_000);
    }

    public CheckingAccount(final String iban, final double balance,final double overdraftAmount) {
        super(iban, balance); // super class constructor
        this.overdraftAmount = overdraftAmount;
    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }

    @Override
    public boolean withdraw(final double amount) {
        System.err.println("CheckingAccount::withdraw");
        // validation
        if (amount <= 0.) return false;
        // business rule
        if (amount > (balance + overdraftAmount)) return false;
        balance -= amount;
        return false;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "iban=" + getIban() +
                "overdraftAmount=" + overdraftAmount +
                ", balance=" + balance +
                '}';
    }
}
