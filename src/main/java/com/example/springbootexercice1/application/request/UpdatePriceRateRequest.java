package com.example.springbootexercice1.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePriceRateRequest {

    private final Double price;
    private final Long id;
}
