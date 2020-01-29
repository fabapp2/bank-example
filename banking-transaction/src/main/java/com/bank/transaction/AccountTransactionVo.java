package com.bank.transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AccountTransactionVo {

    private Money amount;
    private Type type;

    public AccountTransactionVo(Type type, Money amount) {
        this.type = type;
        this.amount = amount;
    }

    public AccountTransactionVo(Type type) {
        this.type = type;
    }

    public enum Type {
        WITHDRAWAL, DEPOSIT;
    }


}
