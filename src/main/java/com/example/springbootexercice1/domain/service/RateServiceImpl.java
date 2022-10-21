package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.infraestructure.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public Long addRate(Rate rate) {
        Rate save = rateRepository.save(rate);
        return save.getId();
    }

    @Override
    public Long getRate(Rate rate) {
        return null;
    }

    @Override
    public Long updateRate(Long id) {
        return null;
    }

    @Override
    public Long deleteRate(Long id) {
        return null;
    }

    @Override
    public List<Rate> findByDatesAndBrandIdAndProductId(Date date, Long brandId, Long productId) {
        return rateRepository.findAllBetweenDatesAndBrandIdAndProductId(date, brandId, productId);
    }
}
