package com.bank.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class BankAccountDeserializationTest {


    @Test
    public void testDeserialization() throws JsonProcessingException {
        String json = "\n" +
                "{\n" +
                "  \"accountNumber\": {\"value\": \"12345\"},\n" +
                "  \"balance\": {\"amount\":  115, \"currency\": \"SGD\"}\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        final BankAccount bankAccount = objectMapper.readValue(json, BankAccount.class);

    }
}
