package com.bank.account;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountTransaction {

    public enum Type {
        WITHDRAWAL, DEPOSIT
    }

    private Type type;

    private Money amount;

}
