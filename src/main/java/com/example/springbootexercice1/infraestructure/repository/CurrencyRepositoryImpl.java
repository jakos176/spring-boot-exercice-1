package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

    private final WebClient webClient;

    @Autowired
    public CurrencyRepositoryImpl(@Value("${currency.url}") String baseUrl) {
        this.webClient = WebClient.create(baseUrl);
    }


    @Override
    public List<Currency> findAll() {
        return webClient.get().uri("/v1/currencies").retrieve().bodyToMono(new ParameterizedTypeReference<List<Currency>>() {
        }).block();
    }

    @Override
    public Currency findCurrencyByCode(String code) {
        return webClient.get().uri("/v1/currency/" + code).retrieve().bodyToMono(new ParameterizedTypeReference<Currency>() {
        }).block();
    }
}
