package com.example.springbootexercice1.application.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class NotFoundRateBetweenDatesResponse implements RateResponse {

    private String message;
    private Long productId;
    private Long brandId;

    private Date date;

    public NotFoundRateBetweenDatesResponse(Date date, Long brandId, Long productId) {
        this.brandId = brandId;
        this.productId = productId;
        this.date = date;
        this.message = String.format("No rates have been found in the date range of %s or brandId %s or productId %s", date.toString(), brandId, productId);
    }

    @Override
    public String toString() {
        return this.message;
    }
}
