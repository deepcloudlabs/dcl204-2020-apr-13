package com.example.banking;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

import java.util.concurrent.ThreadLocalRandom;

// Object Header : 12 Byte, VT Reference
// Polymorphism: Run-time Mechanism -> Virtual Table
// 1: Inheritance
// 2: Super Class Reference --> Account
// 3: Polymorphic (business method) -> withdraw, deposit
public class StudyPolymorphism {
    public static void main(String[] args) {
        int x = 42; // primitive -> int -> 4 Byte
        Integer y = 42; // 16 Byte (heap) + 4 Byte (Stack) = 20 Byte
        Object o;
        o = 42; // 12+4 = 16 Byte
        o = Integer.valueOf(42);
        o = new int[]{1,2,3,4,5,6};
        o = "Jack Bauer";
        o = '\u20BA';
        o = new  Account("TR1", 1_000_000);
        Account account;
        if (ThreadLocalRandom.current().nextBoolean())
            account = new Account("TR1", 1_000_000);
        else
            account = new CheckingAccount("TR2", 2_000_000);
        System.err.println(account.getClass().getSimpleName());
        account.withdraw(25_000.);
        System.out.println(account);
    }
}

class A {}