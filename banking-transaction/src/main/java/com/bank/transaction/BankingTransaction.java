package com.bank.transaction;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.number.money.MonetaryAmountFormatter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BankingTransaction {

    @Id @GeneratedValue
    private Long id;

    private String bankAccountNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name= "amount")),
            @AttributeOverride(name = "currency", column = @Column(name= "amountCurrency"))
    })
    private Money amount;

    @Embedded
    private TellerId tellerId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name= "resultingBalance")),
            @AttributeOverride(name = "currency", column = @Column(name= "resultingBalanceCurrency"))
    })
    private Money resultingBalance;

    @Embedded
    private TransactionSequence transactionSequence;
}
