package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    private final List<Customer> customers;

    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
        customers = new ArrayList<>();
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

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }
    //endregion

    // business methods
    public Customer createCustomer(final String identity,final String fullName) {
        Customer customer = new Customer(identity, fullName);
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> findCustomerByIdentity(final String identity) {
        for (Customer customer : customers) {
            if (customer.getIdentity().equals(identity))
                return Optional.of(customer);
        }
        return Optional.empty();
    }

    public Optional<Customer> findCustomerByIdentity8(final String identity) {
        return customers.stream()
                     .filter(cust -> cust.getIdentity().equals(identity))
                     .findFirst();
    }

    public double getTotalBalance() {
        double sum = 0. ;
        for (Customer customer : customers){
            sum += customer.getTotalBalance();
        }
        return sum;
    }

    public double getTotalBalance8() {
        return customers.stream()
                .mapToDouble(Customer::getTotalBalance8)
                .sum();
    }

}
