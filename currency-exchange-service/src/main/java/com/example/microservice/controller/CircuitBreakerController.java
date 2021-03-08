package com.example.microservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    static int x = 1;

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    public String getSampleApi(){
        return "sample-api";
    }

    @GetMapping("/sample-api-v2")
//    @Retry(name = "defualt")
    @Retry(name = "sample-api")
    public String getSampleApiV2(){
        logger.info("Sample Api Call received");
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/dumy_url", String.class);
        return entity.getBody();
    }

    @GetMapping("/sample-api-v3")
//    @Retry(name = "defualt")
//    @Retry(name = "sample-api-v3" , fallbackMethod = "hardCodedResponse")

    //when there is an error in any micro service and there 100 request come
    // then circuitbreaker gives a default response withour hitting the micro service
    //here fallback method gives a response
//    @CircuitBreaker(name = "default" , fallbackMethod = "hardCodedResponse")

    //here in rate limiter is used for every 10s you can 1000 request in that way it is work
//    @RateLimiter(name = "default")

    //bulkhead allow how many concurrent called can happened at time
    @Bulkhead(name = "default")
    public String getSampleApiV3(){
        logger.info("Sample Api Call received"+x++);
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/dumy_url", String.class);
        return entity.getBody();
    }

    public String hardCodedResponse(Exception ex) {
        return "failed to response";
    }
}
