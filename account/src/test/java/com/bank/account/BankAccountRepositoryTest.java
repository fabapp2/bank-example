package com.bank.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.constraints.NotNull;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BankAccountRepositoryTest {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Test
    public void findBankAccountByAccountNumber() {
        BankAccount ba = new BankAccount();
        @NotNull AccountNumber an = new AccountNumber("1234");
        ba.setAccountNumber(an);
        ba.setBalance(new Money(120, Currency.getInstance("SGD")));
        BankAccount persistedBankAccount = bankAccountRepository.save(ba);
        final BankAccount foundBankAccount = bankAccountRepository.getByAccountNumber(an);
        assertThat(foundBankAccount.getAccountNumber()).isEqualTo(an);
    }

}
