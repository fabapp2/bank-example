package com.bank.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccount findBankAccount(AccountNumber accountNumber) {
        return bankAccountRepository.getByAccountNumber(accountNumber);
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        if(bankAccountRepository.existsByAccountNumber(bankAccount.getAccountNumber())) {
            throw new BankAccountAlreadyExistsException(String.format("Bank account with accountNumber %s already exists", bankAccount.getAccountNumber()));
        }
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
        final BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        log.info("Created new BankAccount {}", savedBankAccount.getAccountNumber());
        return savedBankAccount;
    }
}
