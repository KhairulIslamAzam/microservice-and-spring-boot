package com.example.currencyexchange.controller;

import com.example.currencyexchange.model.CurrencyExchange;
import com.example.currencyexchange.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class Controller {
    @Autowired
    private CurrencyRepository currencyRepository;
    private Logger myLogger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/save")
    public long save(@RequestBody CurrencyExchange c){
        currencyRepository.save(c);
        return currencyRepository.count();
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getOne(@PathVariable String from, @PathVariable String to){

        CurrencyExchange byCurrencyFromAndCurrencyTo = currencyRepository.findByCurrencyFromAndCurrencyTo(from, to);
        myLogger.info("{}", byCurrencyFromAndCurrencyTo);
        return byCurrencyFromAndCurrencyTo;
    }
}
