package com.example.springbootexercice1.domain.service;

import com.example.springbootexercice1.application.response.DataRateResponse;
import com.example.springbootexercice1.domain.model.Currency;
import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.infraestructure.repository.CurrencyRepositoryImpl;
import com.example.springbootexercice1.infraestructure.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateServiceImplTest {


    @Mock
    private CurrencyRepositoryImpl currencyRepository;

    @Mock
    private RateRepository rateRepository;

    @InjectMocks
    private RateServiceImpl rateService;


    @Test
    void addRate() {
        Rate rate = Rate.builder().brandId(2L).currency("USD").build();
        Currency currency = Currency.builder().code("USD").decimals(2).build();
        when(rateRepository.save(any(Rate.class))).thenReturn(rate);
        when(currencyRepository.findCurrencyByCode("USD")).thenReturn(currency);

        DataRateResponse dataRateResponse = rateService.addRate(rate);

        assertEquals(2L, dataRateResponse.getRate().getBrandId());
        assertEquals("USD", dataRateResponse.getCurrency().getCode());
        assertEquals(2, dataRateResponse.getCurrency().getDecimals());
    }

    @Test
    void findRateById() {
        //todo
    }

    @Test
    void deleteRate() {
        //todo
    }

    @Test
    void findByDatesAndBrandIdAndProductId() {
        //todo
    }
}