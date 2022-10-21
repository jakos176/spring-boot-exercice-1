package com.example.springbootexercice1.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_rates")
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "CURRENCY_CODE")
    private String currency;

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
