package com.example.springbootexercice1.application.response;


import com.example.springbootexercice1.domain.model.Currency;
import com.example.springbootexercice1.domain.model.Rate;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class DataRateResponse implements RateResponse {

    @NonNull
    private Rate rate;

    private Currency currency;

    @Override
    public String toString() {
        BigDecimal price = BigDecimal.valueOf(rate.getPrice()).setScale(currency.getDecimals(), RoundingMode.HALF_DOWN);
        return String.format("RateId: %s, RatePrice: %s, rateCode: %s, rateSymbol: %s", rate.getId(), price, currency.getCode(), currency.getSymbol());

    }
}

