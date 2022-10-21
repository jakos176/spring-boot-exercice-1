package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {

    List<Rate> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(Date startDate, Date endDate, Long brandId, Long productId);
}
