package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.infraestructure.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
