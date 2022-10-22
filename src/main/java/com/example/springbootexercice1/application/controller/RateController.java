package com.example.springbootexercice1.application.controller;

import com.example.springbootexercice1.application.request.AddRateRequest;
import com.example.springbootexercice1.application.response.DateRateResponse;
import com.example.springbootexercice1.application.response.NotFoundRateResponse;
import com.example.springbootexercice1.application.response.RateResponse;
import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.domain.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/rates")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DateRateResponse> addRate(@RequestBody final AddRateRequest createOrderRequest) {
        final Rate rate = rateService.addRate(createOrderRequest.getRate());
        return new ResponseEntity<>(new DateRateResponse(rate), HttpStatus.OK);
    }

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> findRateById(@RequestParam final Long id) {
        final Optional<Rate> rate = rateService.findRateById(id);
        if (rate.isPresent()) {
            return new ResponseEntity<>(new DateRateResponse(rate.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(id), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/updatePrice", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> updatePriceRate(@RequestBody final Integer price, @RequestParam final Long id) {
        final Optional<Rate> rate = rateService.updatePriceRate(id, price);
        if (rate.isPresent()) {
            return new ResponseEntity<>(new DateRateResponse(rate.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(id), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> deleteRate(@RequestParam final Long id) {
        final Optional<Rate> rate = rateService.deleteRate(id);
        if (rate.isPresent()) {
            return new ResponseEntity<>(new DateRateResponse(rate.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(id), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/findByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    void addRate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam Long brandId, @RequestParam Long productId) {
        rateService.findByDatesAndBrandIdAndProductId(date, brandId, productId);
    }
}
