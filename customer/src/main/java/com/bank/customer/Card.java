package com.bank.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer owner;

    @Embedded
    private CardNumber number;

    @Embedded
    private Pin pin;

    public Card(String cardNumber, String pin) {
        this.number = new CardNumber(cardNumber);
        this.pin = new Pin(pin);
    }
}
