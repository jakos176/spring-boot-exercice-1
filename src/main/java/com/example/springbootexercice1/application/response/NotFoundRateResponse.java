package com.example.springbootexercice1.application.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class NotFoundRateResponse implements RateResponse {

    private String message;
    private Long id;

    public NotFoundRateResponse(Long id) {
        this.id = id;
        this.message = "Rate with id: " + id + " not found";
    }

    @Override
    public String toString() {
        return this.message;
    }
}
