package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.domain.model.Rate;

import java.util.Date;
import java.util.List;

public interface RateService {

    Long addRate(Rate rate);

    Long getRate(Rate rate);

    Long updateRate(Long id);

    Long deleteRate(Long id);

    List<Rate> findByDatesAndBrandIdAndProductId(Date date,  Long brandId, Long productId);
}
