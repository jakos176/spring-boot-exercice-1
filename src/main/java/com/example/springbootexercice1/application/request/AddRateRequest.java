package com.example.springbootexercice1.application.request;

import com.example.springbootexercice1.domain.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class AddRateRequest {

    @NotNull
    private final Rate rate;
}
