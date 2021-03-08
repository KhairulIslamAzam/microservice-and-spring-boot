package com.example.currencyexchange;

import com.example.currencyexchange.model.CurrencyExchange;
import com.example.currencyexchange.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class InitailData implements CommandLineRunner {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public void run(String... args) throws Exception {
        CurrencyExchange currencyExchange = new CurrencyExchange("USD", "BD", 85);
        CurrencyExchange currencyExchange2 = new CurrencyExchange("EUR", "BD", 105);
        CurrencyExchange currencyExchange3 = new CurrencyExchange("DINAR", "BD", 225);
        currencyRepository.save(currencyExchange);
        currencyRepository.save(currencyExchange2);
        currencyRepository.save(currencyExchange3);
    }
}
