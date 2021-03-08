package com.example.currencycalculator.controller;

import com.example.currencycalculator.model.CurrencyConvert;
import com.example.currencycalculator.repository.proxy.CurrencyExchangeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-calculator")
public class Controller {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;
    private Logger myLogger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/from/{from}/to/{to}/quatity/{q}")
    public CurrencyConvert getOne(@PathVariable String from, @PathVariable String to, @PathVariable long q){
        CurrencyConvert currencyConvertTemp = currencyExchangeProxy.getOne(from, to);
        myLogger.info("{}", currencyConvertTemp);
        currencyConvertTemp.setQuantity(q);
        currencyConvertTemp.setTotalAmmount(currencyConvertTemp.getRate()*q);
        return currencyConvertTemp;
    }
}
