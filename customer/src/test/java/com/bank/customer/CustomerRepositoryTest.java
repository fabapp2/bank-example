package com.bank.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findCustomerByCard() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        Card card = new Card();
        card.setOwner(customer);
        CardNumber cn = new CardNumber("111111");
        card.setNumber(cn);
        Pin pin = new Pin("1111");
        card.setPin(pin);
        customer.getCards().add(card);
        customerRepository.save(customer);

        final Optional<Customer> optionalCustomer = customerRepository.findCustomerByCard(pin, cn);

        assertThat(optionalCustomer.get().getCards().get(0).getNumber()).isEqualTo(cn);
    }
}
