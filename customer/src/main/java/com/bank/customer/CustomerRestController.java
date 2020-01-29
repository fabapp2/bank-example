package com.bank.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerService customerService;

    @GetMapping("/customers/cards/{cardNumber}")
    public HttpEntity<Customer> getCustomerByCardAndPin(@PathVariable("cardNumber") String cardNumber, @RequestHeader("pin") String pin) {
        Customer customer = customerService.getCustomerByCard(cardNumber, pin);
        HttpEntity<Customer> customerResponse = new ResponseEntity<>(customer, HttpStatus.OK);
        return customerResponse;
    }

    @PostMapping("/customers")
    public HttpEntity<Customer> newCustomer(@RequestBody Customer customer) {
        customer = customerService.saveCustomer(customer);
        HttpEntity<Customer> customerResponse = new ResponseEntity<>(customer, HttpStatus.CREATED);
        return customerResponse;
    }

    @PostMapping("/customers/{customerId}/cards")
    public HttpEntity<Customer> newCard(@PathVariable("customerId") Long customerId, @RequestBody Card card) {
        Customer customer = customerService.addCard(customerId, card);
        HttpEntity<Customer> customerResponse = new ResponseEntity<>(customer, HttpStatus.CREATED);
        return customerResponse;
    }
}
