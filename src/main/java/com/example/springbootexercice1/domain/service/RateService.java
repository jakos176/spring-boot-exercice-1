package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.domain.model.Rate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RateService {

    Rate addRate(Rate rate);

    Optional<Rate> findRateById(Long id);

    Optional<Rate> updatePriceRate(Long id, Integer price);

    Optional<Rate> deleteRate(Long id);

    List<Rate> findByDatesAndBrandIdAndProductId(Date date, Long brandId, Long productId);
}
