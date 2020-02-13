package com.bank.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankingTransactionService {

    private final AccountServiceFacade accountServiceFacade;
    private final BankingTransactionSequenceService bankingTransactionSequenceService;
    private final BankingTransactionRepository bankingTransactionRepository;

    public BankingTransaction withdrawal(BankingTransaction bankingTransaction) {
        TellerId tellerId = bankingTransaction.getTellerId();
        TransactionSequence transactionSequence = bankingTransactionSequenceService.createWithdrawalTransactionSequence(tellerId);
        bankingTransaction.setTransactionSequence(transactionSequence);
        AccountTransactionVo accountTransactionVo = new WithdrawalTransactionVo(bankingTransaction.getAmount());
        final BankAccount bankAccount = accountServiceFacade.transactAccount(bankingTransaction.getBankAccountNumber(), accountTransactionVo);
        bankingTransaction.setResultingBalance(bankAccount.getBalance());
        bankingTransaction = bankingTransactionRepository.save(bankingTransaction);
        return bankingTransaction;
    }
}
