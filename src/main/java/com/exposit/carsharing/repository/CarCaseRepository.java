package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.CarCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCaseRepository extends JpaRepository<CarCase, Integer> {
}
