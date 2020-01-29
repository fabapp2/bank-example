package com.bank.transaction;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TransactionSequence {
    @Column(name = "sequence")
    private Long sequence;
}
