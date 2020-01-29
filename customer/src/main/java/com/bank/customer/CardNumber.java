package com.bank.customer;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CardNumber {
    @Column(name = "cardNumber")
    private String value;

}
