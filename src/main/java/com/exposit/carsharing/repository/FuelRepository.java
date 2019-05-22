package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<Fuel, Integer> {
}
