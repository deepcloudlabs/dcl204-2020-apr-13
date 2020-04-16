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
    public void withdraw(final double amount) throws InsufficientBalanceException {
        System.err.println("CheckingAccount::withdraw");
        // validation
        if (amount <= 0.)
            throw new IllegalArgumentException("Amount must be positive!");
        // business rule
        if (amount > (balance + overdraftAmount)) {
            double deficit = amount - balance - overdraftAmount;
            throw new InsufficientBalanceException("Your balance does not cover your expenses!", deficit);
        }
        balance -= amount;
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
