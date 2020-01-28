package com.bank.account;

public class BankAccountException extends RuntimeException {
    public BankAccountException(String message, Exception cause) {
        super(message, cause);
    }
}
