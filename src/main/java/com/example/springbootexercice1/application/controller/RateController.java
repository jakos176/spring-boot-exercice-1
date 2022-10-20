package com.example.springbootexercice1.application.controller;

import com.example.springbootexercice1.application.request.AddRateRequest;
import com.example.springbootexercice1.application.response.AddRateResponse;
import com.example.springbootexercice1.domain.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rates")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AddRateResponse addRate(@RequestBody final AddRateRequest createOrderRequest) {
        final Long id = rateService.addRate(createOrderRequest.getRate());

        return new AddRateResponse(id);
    }
}
