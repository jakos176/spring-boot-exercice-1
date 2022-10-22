package com.example.springbootexercice1.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    private Integer decimals;

    private String code;

    private Character symbol;
}
