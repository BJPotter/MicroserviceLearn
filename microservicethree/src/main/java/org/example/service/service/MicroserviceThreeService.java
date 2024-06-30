package org.example.service.service;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class MicroserviceThreeService {

    @Autowired
    private RestTemplate restTemplate;



    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @TimeLimiter(name = "microserviceThree")
    @Retry(name = "microserviceThree")
    public CompletableFuture<String> callMicroservice(String url) {
        return CompletableFuture.supplyAsync(() ->
                circuitBreakerFactory.create("microserviceThree").run(
                        () -> restTemplate.getForObject(url, String.class),
                        throwable -> "Fallback response"
                )
        );
    }
}
