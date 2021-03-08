package com.example.currencycalculator;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CurrencyCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyCalculatorApplication.class, args);
    }

    @Bean
    public Sampler sampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
