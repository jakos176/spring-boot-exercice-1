package com.example.springbootexercice1.application.response;


import com.example.springbootexercice1.domain.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DateRateResponse implements RateResponse{

    private Rate rate;

}
