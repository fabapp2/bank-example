package com.bank.account;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
public class CdcBaseClass {

    @MockBean
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountsRestController bankAccountsRestController;

    @BeforeEach
    public void setup() {
        BankAccount bankAccount = new BankAccount();
        final AccountNumber accountNumber = new AccountNumber("accountNumber");
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setId(1L);
        given(bankAccountRepository.getByAccountNumber(accountNumber)).willReturn(bankAccount);
        given(bankAccountRepository.save(bankAccount)).willReturn(bankAccount);
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(bankAccountsRestController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}
