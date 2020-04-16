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
    public void deposit(final double amount) {
        // validation
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive!");
        // business logic
        // this.balance = this.balance + amount ;
        this.balance += amount;
    }

    // Ctrl + D : Duplicate
    // Alt + Shift + Up/Down Arrow
    // Ctrl + Alt + L
    // IllegalArgumentException -> (1) RuntimeException -> Uncheck Exception -> Do not declare Runtime Exceptions
    // InsufficientBalanceException -> (2) Business Exception -> Exception -> Check Exception
    public void withdraw(final double amount) throws InsufficientBalanceException {
        System.err.println("Account::withdraw");
        // validation
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive!");
        // business rule
        if (amount > balance)
            throw new InsufficientBalanceException("Your balance does not cover your expenses!",amount-balance);
        // business logic
        // this.balance = this.balance - amount ;
        this.balance -= amount;
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
