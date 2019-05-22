package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
