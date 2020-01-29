package com.bank.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select cust from Customer cust, Card c where c.number = :cardNumber and c.pin = :pin and c member of cust.cards")
    Optional<Customer> findCustomerByCard(@Param("pin") Pin pin, @Param("cardNumber") CardNumber cardNumber);
    //@Query("select c from Customer c where :card member of c.cards")
//    Optional<Customer> findCustomerByCard(Card card);

}
