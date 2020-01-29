package com.bank.transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@Embeddable
public class Money {
    private BigDecimal amount;
    private Currency currency;
}
