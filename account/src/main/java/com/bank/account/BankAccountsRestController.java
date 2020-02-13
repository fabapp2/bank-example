package com.bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@Service
@RestController
@RequiredArgsConstructor
public class BankAccountsRestController {

    private final BankAccountService bankAccountService;

    @GetMapping("/accounts/{accountNumber}")
    public HttpEntity<BankAccount> getBankAccount(@PathParam("accountNumber") AccountNumber accountNumber) {
        BankAccount bankAccount = bankAccountService.findBankAccount(accountNumber);
        HttpEntity<BankAccount> bankAccountResponse = new ResponseEntity<>(bankAccount, HttpStatus.OK);
        return bankAccountResponse;
    }

   @PostMapping(value = "/accounts/{accountNumber}/transactions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   public HttpEntity<BankAccount> transactAccount(@PathParam("accountNumber") AccountNumber accountNumber, @RequestBody AccountTransaction accountTransaction) {
       final BankAccount bankAccount = bankAccountService.transactAccount(accountNumber, accountTransaction);
       HttpEntity<BankAccount> bankAccountResponse = new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
       return bankAccountResponse;
   }

    @PostMapping("/accounts")
    public HttpEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountService.createBankAccount(bankAccount);
        HttpEntity<BankAccount> bankAccountResponse = new ResponseEntity<>(bankAccount, HttpStatus.CREATED);
        return bankAccountResponse;
    }

}
