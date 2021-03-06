package com.bank.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Getter
@Setter
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "accountNumber", nullable = false, unique = true))
    private AccountNumber accountNumber;

    private Money balance = new Money(0, Currency.getInstance("SGD"));

    public Money withdrawal(Money amount) {
        try {
            balance.substract(amount);
            return balance;
        } catch (Exception e) {
            throw new BankAccountException(String.format("Could not withdrawal %s from account %s", amount, accountNumber.getValue()), e);
        }
    }

    public Money deposit(Money amount) {
        try {
            balance.add(amount);
            return null;
        } catch (Exception e) {
            throw new BankAccountException(String.format("Could not deposit %s to account %s", amount, accountNumber.getValue()), e);
        }
    }
}
