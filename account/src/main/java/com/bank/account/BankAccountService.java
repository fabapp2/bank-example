package com.bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccount findBankAccount(AccountNumber accountNumber) {
        return bankAccountRepository.getByAccountNumber(accountNumber);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
}
