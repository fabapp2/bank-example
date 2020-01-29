package com.bank.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class WithdrawalTransactionVo extends AccountTransactionVo {
    public WithdrawalTransactionVo() {
        super(Type.WITHDRAWAL);
    }
    public WithdrawalTransactionVo(Money amount) {
        super(Type.WITHDRAWAL, amount);
    }
}
