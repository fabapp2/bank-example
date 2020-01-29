package com.bank.transaction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "accounts", url = "${accounts.feign.url}")
public interface AccountServiceFacade {
    @RequestMapping(method = RequestMethod.POST, value="/accounts/{accountNumber}/transactions", consumes = "application/json")
    BankAccount transactAccount(@PathVariable("accountNumber") String accountNumber, AccountTransactionVo accountTransactionVo);
}
