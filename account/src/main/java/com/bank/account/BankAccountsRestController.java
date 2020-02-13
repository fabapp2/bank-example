package com.bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Service
@RestController
@RequiredArgsConstructor
public class BankAccountsRestController {

    private final BankAccountService bankAccountService;
    private final BankAccountMapper bankAccountMapper;

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


   // TODO: Best way to test (unit, integration, acceptance,...) that an account with existing accountNumber can't be created again and results in an exception ?
    @PostMapping("/accounts")
    public HttpEntity<BankAccount> createBankAccount(@RequestBody CreateBankAccountRequest createBankAccountRequest) {
        BankAccount bankAccount = bankAccountMapper.map(createBankAccountRequest);
        BankAccount createdBankAccount = bankAccountService.createBankAccount(bankAccount);
        HttpEntity<BankAccount> bankAccountResponse = new ResponseEntity<>(createdBankAccount, HttpStatus.CREATED);
        return bankAccountResponse;
    }

    /**
     * Return a status code of 409 if a bank account already exists
     *
     * 409 (Conflict) should not be used for a public Api as it reveals internals and potentially imposes a security issue.
     *
     * @see <a href="https://tools.ietf.org/html/draft-ietf-httpbis-p2-semantics-18#section-7.4.10">ietf</a>
     * <a href="https://stackoverflow.com/a/32531069/12312591">stackoverflow</a>
     */
    @ExceptionHandler(BankAccountAlreadyExistsException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "The Account already exists.")
    public void handle(BankAccountAlreadyExistsException e) {
    }


}
