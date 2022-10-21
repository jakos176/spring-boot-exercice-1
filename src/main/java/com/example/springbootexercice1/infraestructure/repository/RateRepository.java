package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Rate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {

    @Query(value = "SELECT * FROM T_RATES WHERE :date BETWEEN start_date " +
            "AND end_date AND brand_id = :brandId AND product_id = :productId", nativeQuery = true)
    List<Rate> findAllBetweenDatesAndBrandIdAndProductId(Date date, Long brandId, Long productId);

//    List<Rate> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(Date startDate, Date endDate, Long brandId, Long productId);
}
