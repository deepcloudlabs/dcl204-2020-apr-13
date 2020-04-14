package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Customer {
    private final String identity;
    private String fullName;
    private List<Account> accounts;

    //region constructors
    public Customer(String identity, String fullName) {
        this.identity = identity;
        this.fullName = fullName;
        accounts = new ArrayList<>(); // empty list
    }
    //endregion

    //region setters and getters

    public String getIdentity() {
        return identity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    //endregion

    // information hiding : private, immutability

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts); // immutable list
    }

    // business methods
    public void addAccount(Account account){
        accounts.add(account) ; // composition: accounts (List), Delegation
    }

    // javac
    // javadoc : internal documentation ==> browsable html
    /**
     *
     * @param iban
     * @return
     */
    public Optional<Account> findAccountByIban(String iban){
        // NPE: NullPointerException
        for (Account acc : accounts){ // External Loop
            if (acc.getIban().equals(iban))
                return Optional.of(acc);
        }
        return Optional.empty();
    }

    public Optional<Account> findAccountByIban8(String iban){
        // Lambda Expression
        // Stream API .parallel() => Java SE 7 : ForkJoin Framework : Data Parallelism
        // Internal Loop
        return accounts.stream().filter( acc -> acc.getIban().equals(iban)).parallel().findFirst();
    }

    public double getTotalBalance(){
        double sum = 0. ;
        for (Account acc : accounts) { // External Loop
            sum += acc.getBalance();
        }
        return sum;
    }
    public double getTotalBalance8(){
        return accounts.stream()
                       .mapToDouble( Account::getBalance )
                       .sum();
    }
}
