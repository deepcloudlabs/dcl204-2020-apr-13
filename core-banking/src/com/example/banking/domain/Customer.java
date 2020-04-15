package com.example.banking.domain;

import java.util.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Customer {
    private final String identity;
    private String fullName;
    private final Map<String,Account> accounts;

    //region constructors
    public Customer(final String identity, final String fullName) {
        this.identity = identity;
        this.fullName = fullName;
        accounts = new HashMap<>(); // empty list
    }
    //endregion

    //region setters and getters

    public String getIdentity() {
        return identity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }
    //endregion

    // information hiding : private, immutability

    public Collection<Account> getAccounts() {
        return accounts.values(); // immutable list
    }

    // business methods
    public void addAccount(final Account account) {
        accounts.put(account.getIban(),account); // composition: accounts (List), Delegation
    }

    // javac
    // javadoc : internal documentation ==> browsable html

    /**
     * @param iban IBAN Number
     * @return Returns account
     */
    public Optional<Account> findAccountByIban(final String iban) {
        return Optional.ofNullable(accounts.get(iban));
    }

    public Optional<Account> findAccountByIban8(final String iban) {
        return accounts.values().stream().filter(acc -> acc.getIban().equals(iban)).parallel().findFirst();
    }

    public double getTotalBalance() {
        double sum = 0.;
        for (Account acc : accounts.values()) { // External Loop
            sum += acc.getBalance();
        }
        return sum;
    }

    public double getTotalBalance8() {
        return accounts.values().stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }
}
