package com.bank.account;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
class AccountNumber implements Serializable {
    @Column(name = "accountNumber")
    private String value;
}
