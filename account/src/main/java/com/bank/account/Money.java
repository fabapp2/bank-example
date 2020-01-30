package com.bank.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Money {

    private BigDecimal amount;
    private Currency currency;

    public Money(int amount, Currency currency) {
        this(new BigDecimal(amount), currency);
    }

    public void substract(Money money) {
        if(currency.equals(money.getCurrency())) {
            this.amount = this.amount.subtract(money.getAmount());
        } else {
            throw new InvalidCurrencyException(String.format("Failed to substract %s from money in %s.", money.getCurrency(), currency ));
        }
    }

    public void add(Money money) {
        if(currency.equals(money.getCurrency())) {
            this.amount = this.amount.add(money.getAmount());
        } else {
            throw new InvalidCurrencyException(String.format("Failed to add %s to money in %s.", money.getCurrency(), currency ));
        }
    }
}
