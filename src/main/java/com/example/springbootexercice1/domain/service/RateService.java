package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.application.response.DataRateResponse;
import com.example.springbootexercice1.application.response.DatasRateResponse;
import com.example.springbootexercice1.domain.model.Rate;

import java.util.Date;

public interface RateService {

    DataRateResponse addRate(Rate rate);

    DataRateResponse findRateById(Long id);

    DataRateResponse updatePriceRate(Long id, Double price);

    DataRateResponse deleteRate(Long id);

    DatasRateResponse findByDatesAndBrandIdAndProductId(Date date, Long brandId, Long productId);
}
