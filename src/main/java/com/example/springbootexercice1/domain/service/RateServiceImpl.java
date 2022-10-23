package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.application.response.DataRateResponse;
import com.example.springbootexercice1.application.response.DatasRateResponse;
import com.example.springbootexercice1.domain.model.Currency;
import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.infraestructure.repository.CurrencyRepository;
import com.example.springbootexercice1.infraestructure.repository.RateRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RateServiceImpl implements RateService {

    private final RateRepository rateRepository;

    private final CurrencyRepository currencyRepository;


    public RateServiceImpl(RateRepository rateRepository, CurrencyRepository currencyRepository) {
        this.rateRepository = rateRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public DataRateResponse addRate(Rate rate) {
        Rate rateSaved = rateRepository.save(rate);
        Currency currency = getCurrencyByCode(rate.getCurrency());
        return DataRateResponse.builder().rate(rateSaved).currency(currency).build();
    }

    @Override
    public DataRateResponse findRateById(Long id) {
        Optional<Rate> byId = rateRepository.findById(id);
        DataRateResponse dataRateResponse = null;
        if (byId.isPresent()) {
            Currency currency = getCurrencyByCode(byId.get().getCurrency());
            dataRateResponse = DataRateResponse.builder().currency(currency).rate(byId.get()).build();
        }
        return dataRateResponse;
    }

    @Override
    public DataRateResponse updatePriceRate(Long id, Double price) {
        Optional<Rate> rateToUpdate = rateRepository.findById(id);
        DataRateResponse dataRateResponse = null;
        boolean rateExists = rateToUpdate.isPresent();
        if (rateExists) {
            Rate rate = rateToUpdate.get();
            rate.setPrice(price);
            rateRepository.save(rate);
            Currency currency = getCurrencyByCode(rate.getCurrency());
            dataRateResponse = DataRateResponse.builder().currency(currency).rate(rate).build();
        }

        return dataRateResponse;
    }

    @Override
    public DataRateResponse deleteRate(Long id) {
        Optional<Rate> rateToDelete = rateRepository.findById(id);
        DataRateResponse dataRateResponse = null;
        if (rateToDelete.isPresent()) {
            Currency currency = getCurrencyByCode(rateToDelete.get().getCurrency());
            dataRateResponse = DataRateResponse.builder().currency(currency).rate(rateToDelete.get()).build();
            rateRepository.delete(rateToDelete.get());
        }
        return dataRateResponse;
    }


    @Override
    public DatasRateResponse findByDatesAndBrandIdAndProductId(Date date, Long brandId, Long productId) {
        List<Rate> allBetweenDatesAndBrandIdAndProductId = rateRepository.findAllBetweenDatesAndBrandIdAndProductId(date, brandId, productId);
        List<DataRateResponse> dataRateResponses = new ArrayList<>();
        for (Rate rate : allBetweenDatesAndBrandIdAndProductId) {
            Currency currency = getCurrencyByCode(rate.getCurrency());
            DataRateResponse dataRateResponse = DataRateResponse.builder().rate(rate).currency(currency).build();
            dataRateResponses.add(dataRateResponse);
        }
        return DatasRateResponse.builder().datasRateResponses(dataRateResponses).build();
    }

    private Currency getCurrencyByCode(String currency) {
        return currencyRepository.findCurrencyByCode(currency);
    }
}
