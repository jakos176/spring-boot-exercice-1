package com.example.springbootexercice1.application.controller;

import com.example.springbootexercice1.application.request.AddRateRequest;
import com.example.springbootexercice1.application.response.*;
import com.example.springbootexercice1.domain.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/rates")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DataRateResponse> addRate(@RequestBody final AddRateRequest createOrderRequest) {
        final DataRateResponse rate = rateService.addRate(createOrderRequest.getRate());
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> findRateById(@RequestParam final Long id) {
        final DataRateResponse rate = rateService.findRateById(id);
        if (rate != null) {
            return new ResponseEntity<>(rate.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(id).toString(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/updatePrice", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> updatePriceRate(@RequestParam final Double price, @RequestParam final Long id) {
        final DataRateResponse rate = rateService.updatePriceRate(id, price);
        if (rate != null) {
            return new ResponseEntity<>(rate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(id), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> deleteRate(@RequestParam final Long id) {
        final DataRateResponse rate = rateService.deleteRate(id);
        if (rate != null) {
            return new ResponseEntity<>(rate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(id), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/findByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> addRate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @RequestParam Long brandId, @RequestParam Long productId) {
        DatasRateResponse byDatesAndBrandIdAndProductId = rateService.findByDatesAndBrandIdAndProductId(date, brandId, productId);
        if (!byDatesAndBrandIdAndProductId.getDatasRateResponses().isEmpty()) {
            return new ResponseEntity<>(byDatesAndBrandIdAndProductId.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateBetweenDatesResponse(date, brandId, productId).toString(), HttpStatus.NOT_FOUND);
        }
    }
}
