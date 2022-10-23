package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Currency;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    @Override
    public List<Currency> findAll() {
        return WebClient.create("http://localhost:8081")
                .get().uri("/v1/currencies").
                retrieve().bodyToMono(new ParameterizedTypeReference<List<Currency>>() {
                }).block();
    }

    @Override
    public Currency findCurrencyByCode(String code) {
        return WebClient.create("http://localhost:8081")
                .get().uri("/v1/currency/" + code).
                retrieve().bodyToMono(new ParameterizedTypeReference<Currency>() {
                }).block();
    }
}
