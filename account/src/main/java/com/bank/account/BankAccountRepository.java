package com.bank.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    @Query("select ba from BankAccount ba where ba.accountNumber = :accountNumber")
    BankAccount getByAccountNumber(@Param("accountNumber") AccountNumber accountNumber);
}
