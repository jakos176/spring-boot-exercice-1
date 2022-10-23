package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Currency;

import java.util.List;

public interface CurrencyRepository {

    List<Currency> findAll();

    Currency findCurrencyByCode(String code);

}
