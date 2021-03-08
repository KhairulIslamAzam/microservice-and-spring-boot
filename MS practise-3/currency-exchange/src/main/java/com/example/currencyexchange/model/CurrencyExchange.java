package com.example.currencyexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter@Setter@NoArgsConstructor
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String currencyFrom;
   private String currencyTo;
   private long rate;
    public CurrencyExchange(String from, String to, long rate) {
        this.currencyFrom = from;
        this.currencyTo = to;
        this.rate = rate;
    }
}
