package com.example.springbootexercice1.application.request;

import com.example.springbootexercice1.domain.model.Rate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class AddRateRequest {

    @NotNull private Rate rate;

    @JsonCreator
    public AddRateRequest(@JsonProperty("rate") final Rate rate) {
        this.rate = rate;
    }
}
