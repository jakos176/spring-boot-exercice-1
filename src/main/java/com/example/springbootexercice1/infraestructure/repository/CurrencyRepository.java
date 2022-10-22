package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository {

    List<Currency> findAll();

    Optional<Currency> getCurrencyByCode(String code);

}
