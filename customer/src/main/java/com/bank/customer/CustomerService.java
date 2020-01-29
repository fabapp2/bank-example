package com.bank.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomerByCard(String cardNumber, String pin) {
        Card card = new Card(cardNumber, pin);
        final Optional<Customer> customerByCard = customerRepository.findCustomerByCard(new Pin(pin), new CardNumber(cardNumber));
        return customerByCard.orElseThrow(() -> new InvalidCardAuthenticationException(card));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer addCard(Long customerId, Card card) {
        final Customer customer = customerRepository.getOne(customerId);
        customer.getCards().add(card);
        card.setOwner(customer);
        return customerRepository.save(customer);
    }
}
