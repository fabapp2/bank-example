package com.bank.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BankingTransactionRestController {

    private final BankingTransactionService bankingTransactionService;

    @PostMapping(value = "/transactions/withdrawals", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<BankingTransaction> withdrawal(@RequestBody BankingTransaction bankingTransaction) {
        bankingTransaction = bankingTransactionService.withdrawal(bankingTransaction);
        HttpEntity<BankingTransaction> returnValue = new ResponseEntity<>(bankingTransaction, HttpStatus.CREATED);
        return returnValue;
    }
}
