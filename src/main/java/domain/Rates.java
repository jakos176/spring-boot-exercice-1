package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_rates")
public class Rates {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "BRAND_ID")
    private Long branId;

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

}
