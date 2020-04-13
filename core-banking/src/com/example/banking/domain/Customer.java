package com.example.banking.domain;

import java.util.ArrayList;
import java.util.List;

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

    // business methods
}
