package com.example.currencycalculator.repository.proxy;

import com.example.currencycalculator.model.CurrencyConvert;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency/from/{from}/to/{to}")
    CurrencyConvert getOne(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to);
}
