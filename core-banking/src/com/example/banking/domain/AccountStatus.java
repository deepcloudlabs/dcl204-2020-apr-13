package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public enum AccountStatus {
    ACTIVE(100), BLOCKED(200), PASSIVE(300);
    private final int code;

    private AccountStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
