package com.bank.account;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
class AccountNumber implements Serializable {
    private String value;
}
