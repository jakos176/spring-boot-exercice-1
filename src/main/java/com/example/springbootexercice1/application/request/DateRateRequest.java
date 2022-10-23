package com.example.springbootexercice1.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DateRateRequest {

    private Date date;
    private Long brandId;
    private Long productId;
}
