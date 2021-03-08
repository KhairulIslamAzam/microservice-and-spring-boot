package com.example.microservice.controller;

import com.example.microservice.model.CurrencyExchange;
import com.example.microservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeRepository currencyExchangeRepository;
    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeService(@PathVariable String from,
                                               @PathVariable String to) {

//        hard coded value
//        CurrencyExchange currenExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);

        if (currencyExchange == null) {
            throw new RuntimeException("Unable to fined data for conversion");
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        logger.info("Tracing method "+currencyExchange);

        return currencyExchange;
    }
}
