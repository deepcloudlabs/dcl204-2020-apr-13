package com.example.banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Bank {
    private final int id; // bddk
    private String name;
    private List<Customer> customers;

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
    public Customer createCustomer(String identity,String fullName){
        //TODO: implement the logic
    }

    public Optional<Customer> findCustomerByIdentity(String identity){
        
    }

    public Optional<Customer> findCustomerByIdentity8(String identity){

    }

    public double getTotalBalance(){

    }

    public double getTotalBalance8(){

    }

}
