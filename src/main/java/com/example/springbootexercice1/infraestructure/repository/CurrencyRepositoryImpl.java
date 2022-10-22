package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

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
    public Optional<Currency> getCurrencyByCode(String code) {
        List<Currency> all = this.findAll();
        return all.stream().filter(currency -> currency.getCode().equals(code)).findFirst();
    }
}
