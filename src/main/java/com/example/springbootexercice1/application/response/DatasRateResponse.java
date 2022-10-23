package com.example.springbootexercice1.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class DatasRateResponse implements RateResponse {

    private List<DataRateResponse> datasRateResponses;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        datasRateResponses.forEach(rate -> stringBuilder.append(String.format("%s%n", rate.toString())));
        return stringBuilder.toString();
    }
}
