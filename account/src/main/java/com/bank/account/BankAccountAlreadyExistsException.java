package com.bank.account;

public class BankAccountAlreadyExistsException extends RuntimeException {
    public BankAccountAlreadyExistsException(String message) {
        super(message);
    }
}
