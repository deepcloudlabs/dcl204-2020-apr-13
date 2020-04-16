package com.example.banking.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class CheckingAccountTest {

    @Test
    void withdrawWithNegativeAmountShouldThrowIllegalArgumentException() {
        CheckingAccount account = new CheckingAccount("TR1", 1_000, 500);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1.));
        assertEquals(1_000, account.getBalance());
        assertEquals(500, account.getOverdraftAmount());
    }

    @Test
    void withdrawOverBalanceAndOverdraftShouldThrowInsufficientBalanceException() {
        CheckingAccount account = new CheckingAccount("TR1", 1_000, 500);
        assertThrows(InsufficientBalanceException.class, () -> account.withdraw(1_501.));
        assertEquals(1_000, account.getBalance());
        assertEquals(500, account.getOverdraftAmount());
    }

    @Test
    void withdrawAllBalanceShouldBeOk() throws Throwable {
        CheckingAccount account = new CheckingAccount("TR1", 1_000, 500);
        account.withdraw(1_000.);
        assertEquals(0, account.getBalance());
        assertEquals(500, account.getOverdraftAmount());
    }

    @Test
    void withdrawAllBalanceAndOverdraftAmountShouldBeOk() throws Throwable {
        CheckingAccount account = new CheckingAccount("TR1", 1_000, 500);
        account.withdraw(1_500.);
        assertEquals(-500, account.getBalance());
        assertEquals(500, account.getOverdraftAmount());
    }
}