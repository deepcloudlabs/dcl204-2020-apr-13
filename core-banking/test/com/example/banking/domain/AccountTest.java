package com.example.banking.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Alt + Enter
class AccountTest {
    @Test
    public void depositWithNegativeAmountShouldReturnFalse() {
        // Fixture
        Account acc = new Account("TR1", 1_000);
        assertEquals("TR1", acc.getIban());
        assertEquals(1_000, acc.getBalance());
        // Call exercise method
        // Ctrl + Alt + V
         assertThrows(IllegalArgumentException.class,() -> acc.deposit(-1));
        // Verify state
        assertEquals(1_000, acc.getBalance());
    }

    @Test
    public void depositWithPositiveAmountShouldReturnTrue() {
        // Fixture
        Account acc = new Account("TR1", 1_000);
        assertEquals("TR1", acc.getIban());
        assertEquals(1_000, acc.getBalance());
        // Call exercise method
        acc.deposit(1);
        // Verify state
        assertEquals(1_001, acc.getBalance());
    }

    @Test
    public void withdrawWithNegativeAmountShouldReturnFalse() {
        // Fixture
        Account acc = new Account("TR1", 1_000);
        assertEquals("TR1", acc.getIban());
        assertEquals(1_000, acc.getBalance());
        // Call exercise method
        // Ctrl + Alt + V
        assertThrows(IllegalArgumentException.class,() -> acc.withdraw(-1));
        // Verify state
        assertEquals(1_000, acc.getBalance());
    }

    @Test
    public void withdrawWithOverBalanceShouldReturnFalse() {
        // Fixture
        Account acc = new Account("TR1", 1_000);
        assertEquals("TR1", acc.getIban());
        assertEquals(1_000, acc.getBalance());
        // Call exercise method
        assertThrows(InsufficientBalanceException.class,() -> acc.withdraw(1001));
        // Verify state
        assertEquals(1_000, acc.getBalance());
    }

    @Test
    public void withdrawAllBalanceShouldReturnTrue() throws Throwable {
        // Fixture
        Account acc = new Account("TR1", 1_000);
        assertEquals("TR1", acc.getIban());
        assertEquals(1_000, acc.getBalance());
        // Call exercise method
        acc.withdraw(1000);
        // Verify state
        assertEquals(0, acc.getBalance());
    }

    @Test
    public void toStringShouldContainIbanAndBalance() {
        // Fixture
        Account acc = new Account("TR1");
        assertEquals("TR1", acc.getIban());
        assertEquals(0, acc.getBalance(), 0.0);
        // Call exercise method
        String s = acc.toString();
        // Verify state
        assertTrue(s.contains("iban="));
        assertTrue(s.contains("balance="));
    }


}