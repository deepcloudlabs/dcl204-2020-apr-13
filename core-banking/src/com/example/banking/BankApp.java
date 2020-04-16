package com.example.banking;

import com.example.banking.domain.Account;
import com.example.banking.domain.Bank;
import com.example.banking.domain.Customer;
import com.example.banking.domain.InsufficientBalanceException;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class BankApp {

    public static void main(String[] args) {
        // variable: i) local/temporary/stack/automatic
        //          ii) type -> Class -> Reference variable
        Account acc =
                // creating an object in Heap -> Heap Object
                new Account("TR1", 5_000_000); // uninitialized!
        acc.deposit(1_000_000);
        System.out.println(acc.getBalance());
        try {
            acc.withdraw(4_000_000);
            System.out.println(acc.getBalance());
            acc.withdraw(3_000_000);
            System.out.println(acc.toString());
        }  catch (InsufficientBalanceException e) {
            System.err.println(e.getDeficit());
        }

        Bank bank = new Bank(1, "My Bank");
        Customer jack = bank.createCustomer("1", "Jack Bauer");
        jack.addAccount(new Account("TR1", 10_000));
        jack.addAccount(new Account("TR2", 20_000));
        jack.addAccount(new Account("TR3", 30_000));
        Customer kate = bank.createCustomer("2", "Kate Austen");
        // Alt + Shift + Insert : Column selection mode
        // Esc
        kate.addAccount(new Account("TR4", 40_000));
        kate.addAccount(new Account("TR5", 50_000));
        kate.addAccount(new Account("TR6", 60_000));
        System.out.println(bank.getTotalBalance8());

        bank.findCustomerByIdentity("2")   // SAFE : NPE free
                .ifPresent(   // Null Check
                        customer -> customer.findAccountByIban("TR5")
                                .ifPresent(account -> {
                                    try {
                                        account.withdraw(10_000);
                                    } catch (InsufficientBalanceException e) {
                                        System.err.println(e.getDeficit());
                                    }
                                })
                );
        Customer cust = bank.findCustomerByIdentity("3")
                .orElseThrow(() -> new IllegalArgumentException("No such customer!"));
        System.out.println(cust.getFullName()); // NPE free : SAFE
        System.out.println(bank.getTotalBalance8());
    }
}
