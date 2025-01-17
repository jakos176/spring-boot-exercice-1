package com.example.springbootexercice1.application.request;

import com.example.springbootexercice1.domain.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddRateRequest {

    @NotNull
    private Rate rate;
}
