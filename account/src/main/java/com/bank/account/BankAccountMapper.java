package com.bank.account;

import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount map(CreateBankAccountRequest createBankAccountRequest) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(createBankAccountRequest.getAccountNumber());
        bankAccount.setBalance(createBankAccountRequest.getBalance());
        return bankAccount;
    }
}
