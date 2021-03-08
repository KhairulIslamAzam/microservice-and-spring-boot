package com.example.currencycalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor @AllArgsConstructor
public class CurrencyConvert {
    private long id;
    private String currencyFrom;
    private String currencyTo;
    private long quantity;
    private long rate;
    private long totalAmmount;
}
