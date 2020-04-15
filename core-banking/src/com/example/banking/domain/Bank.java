package com.example.banking.domain;

import java.util.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// OOP
// 1. Class and Object -> Encapsulation + Information Hiding
// 2. Inheritance -> Reusability
// 3. Polymorphism -> Agility
// DDD : Domain-Driven Design
// Entity : Account, Checking Account, Customer
// Value Object: Address
// Aggregate : Bank
// Event Storming => Complex Domain
public class Bank {
    private final int id; // bddk
    private String name;
    private final Map<String,Customer> customers;

    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
        customers = new HashMap<>();
    }

    //region getters/setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Customer> getCustomers() {
        return customers.values();
    }
    //endregion

    // business methods
    public Customer createCustomer(final String identity,final String fullName) {
        Customer customer = new Customer(identity, fullName);
        customers.put(customer.getIdentity(),customer);
        return customer;
    }

    public Optional<Customer> findCustomerByIdentity(final String identity) {
        return Optional.ofNullable(customers.get(identity));
    }

    public Optional<Customer> findCustomerByIdentity8(final String identity) {
        return customers.values().stream()
                     .filter(cust -> cust.getIdentity().equals(identity))
                     .findFirst();
    }

    public double getTotalBalance() {
        double sum = 0. ;
        for (Customer customer : customers.values()){
            sum += customer.getTotalBalance();
        }
        return sum;
    }

    public double getTotalBalance8() {
        return customers.values().stream()
                .mapToDouble(Customer::getTotalBalance8)
                .sum();
    }

}
