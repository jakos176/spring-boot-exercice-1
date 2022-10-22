package com.example.springbootexercice1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CurrencyEnum {

    EUR('€', "EUR"),
    DOLLAR('$', "USD");

    private Character symbol;

    private String code;

    public CurrencyEnum getCurrencyFromCode(String code) {
        return Arrays.stream(CurrencyEnum.values()).filter(currencyEnum -> currencyEnum.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }

    public CurrencyEnum getCurrencyFromSymbol(Character symbol) {
        return Arrays.stream(CurrencyEnum.values()).filter(currencyEnum -> currencyEnum.getSymbol() == symbol).findFirst().orElse(null);
    }

}
