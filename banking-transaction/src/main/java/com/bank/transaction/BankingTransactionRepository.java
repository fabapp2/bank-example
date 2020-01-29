package com.bank.transaction;

import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingTransactionRepository extends JpaRepository<BankingTransaction, Long> {
}
