package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.infraestructure.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    @Autowired
    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public Rate addRate(Rate rate) {
        return rateRepository.save(rate);
    }

    @Override
    public Optional<Rate> findRateById(Long id) {
        return rateRepository.findById(id);
    }

    @Override
    public Optional<Rate> updatePriceRate(Long id, Integer price) {
        Optional<Rate> rateToUpdate = rateRepository.findById(id);

        boolean rateExists = rateToUpdate.isPresent();
        if (rateExists) {
            Rate rate = rateToUpdate.get();
            rate.setPrice(price);
            rateRepository.save(rate);
        }

        return rateToUpdate;
    }

    @Override
    public Optional<Rate> deleteRate(Long id) {
        Optional<Rate> rateToDelete = rateRepository.findById(id);
        rateToDelete.ifPresent(rateRepository::delete);
        return rateToDelete;
    }

    @Override
    public List<Rate> findByDatesAndBrandIdAndProductId(Date date, Long brandId, Long productId) {
        return rateRepository.findAllBetweenDatesAndBrandIdAndProductId(date, brandId, productId);
    }
}
