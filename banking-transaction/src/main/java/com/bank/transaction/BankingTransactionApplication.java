package com.bank.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = AccountServiceFacade.class)
public class BankingTransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankingTransactionApplication.class, args);
    }
}
