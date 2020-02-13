package com.bank.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.bank:account:0.0.1-SNAPSHOT:stubs:8888"
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "accounts.feign.url=http://localhost:8888",
                // "accounts.feign.url2=http://localhost:${stubrunner.runningstubs.account.port}", // not working until https://github.com/spring-cloud/spring-cloud-contract/issues/1303 is resolved

        })

public class BankingTransactionE2ETest {

    @LocalServerPort
    int port;

    @Test
    public void e2e() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        final String url = "http://localhost:" + port + "/transactions/withdrawals";
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        final ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,
                new HttpEntity<String>("{\n" +
                    "  \"bankAccountNumber\":  \"accountNumber\",\n" +
                    "  \"amount\":{\"amount\":  50.00, \"currency\": \"SGD\" },\n" +
                    "  \"tellerId\": {\"value\":  \"T2309\"}\n" +
                    "}", httpHeaders), String.class);

    }
}
