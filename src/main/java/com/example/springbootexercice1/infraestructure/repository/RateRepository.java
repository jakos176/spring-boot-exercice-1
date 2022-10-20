package com.example.springbootexercice1.infraestructure.repository;

import com.example.springbootexercice1.domain.model.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate, Long> {
}
