package com.example.currencyexchange.repository;

import com.example.currencyexchange.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByCurrencyFromAndCurrencyTo(String from, String to);
}
