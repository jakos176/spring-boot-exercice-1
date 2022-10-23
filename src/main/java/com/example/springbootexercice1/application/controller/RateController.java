package com.example.springbootexercice1.application.controller;

import com.example.springbootexercice1.application.request.AddRateRequest;
import com.example.springbootexercice1.application.request.DateRateRequest;
import com.example.springbootexercice1.application.request.FindRateRequest;
import com.example.springbootexercice1.application.request.UpdatePriceRateRequest;
import com.example.springbootexercice1.application.response.*;
import com.example.springbootexercice1.domain.model.Rate;
import com.example.springbootexercice1.domain.service.RateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rates")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DataRateResponse> addRate(@RequestBody final AddRateRequest createOrderRequest) {
        final DataRateResponse rate = rateService.addRate(createOrderRequest.getRate());
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

    @Operation(summary = "Get a Rate by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rate found", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Rate.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Rate not found", content = @Content)})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> findRateById(@Parameter(description = "Object to find") @RequestBody FindRateRequest findRateRequest) {
        final DataRateResponse rate = rateService.findRateById(findRateRequest.getId());
        if (rate != null) {
            return new ResponseEntity<>(rate.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(findRateRequest.getId()).toString(), HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)

    @PatchMapping(value = "/updatePrice", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> updatePriceRate(@RequestBody UpdatePriceRateRequest updatePriceRateRequest) {
        final DataRateResponse rate = rateService.updatePriceRate(updatePriceRateRequest.getId(), updatePriceRateRequest.getPrice());
        if (rate != null) {
            return new ResponseEntity<>(rate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(updatePriceRateRequest.getId()), HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RateResponse> deleteRate(@RequestBody FindRateRequest findRateRequest) {
        final DataRateResponse rate = rateService.deleteRate(findRateRequest.getId());
        if (rate != null) {
            return new ResponseEntity<>(rate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new NotFoundRateResponse(findRateRequest.getId()), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/findByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> addRate(@RequestBody DateRateRequest dateRateRequest) {
        DatasRateResponse byDatesAndBrandIdAndProductId = rateService.findByDatesAndBrandIdAndProductId(dateRateRequest.getDate(), dateRateRequest.getBrandId(), dateRateRequest.getProductId());
        if (!byDatesAndBrandIdAndProductId.getDatasRateResponses().isEmpty()) {
            return new ResponseEntity<>(byDatesAndBrandIdAndProductId.toString(), HttpStatus.OK);
        } else {
            NotFoundRateBetweenDatesResponse notFound = new NotFoundRateBetweenDatesResponse(dateRateRequest.getDate(), dateRateRequest.getBrandId(), dateRateRequest.getProductId());
            return new ResponseEntity<>(notFound.toString(), HttpStatus.NOT_FOUND);
        }
    }
}
