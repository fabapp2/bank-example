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

    public BankAccount transactAccount(AccountNumber accountNumber, AccountTransaction accountTransaction) {
        final BankAccount bankAccount = bankAccountRepository.getByAccountNumber(accountNumber);
        if(accountTransaction.getType().equals(AccountTransaction.Type.WITHDRAWAL)) {
            bankAccount.withdrawal(accountTransaction.getAmount());
        } else if(accountTransaction.getType().equals(AccountTransaction.Type.DEPOSIT)) {
            bankAccount.deposit(accountTransaction.getAmount());
        } else {
            // FIXME: throw exception in case of unknown transaction type
        }
        return bankAccountRepository.save(bankAccount);
    }
}
