package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface CarRepository extends JpaRepository<Car, Integer>
{
}
