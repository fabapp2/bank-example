package com.bank.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidCardAuthenticationException extends RuntimeException {
    public InvalidCardAuthenticationException(Card card) {
        super(String.format("CardNumber and Pin did not match for card %s", card.getNumber()));
    }
}
