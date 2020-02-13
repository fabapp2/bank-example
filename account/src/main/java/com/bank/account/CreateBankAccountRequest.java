package com.bank.account;

import lombok.Getter;
import lombok.Setter;

import java.util.Currency;

@Getter
@Setter
public class CreateBankAccountRequest {
    private AccountNumber accountNumber;
    private Money balance = new Money(0, Currency.getInstance("SGD"));
}
