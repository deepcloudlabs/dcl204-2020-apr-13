package com.example.banking;

import com.example.banking.domain.Account;

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
        acc.withdraw(4_000_000);
        System.out.println(acc.getBalance());
        acc.withdraw(3_000_000);
        System.out.println(acc.toString());
    }
}
