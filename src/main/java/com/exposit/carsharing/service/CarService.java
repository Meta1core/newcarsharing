package com.exposit.carsharing.service;

import com.exposit.carsharing.converter.CarDTO;
import com.exposit.carsharing.model.entity.Car;

import java.util.List;

public interface CarService {
    Car getById(Integer id);
    void save(CarDTO car);
    void update(CarDTO car);
    void delete(Integer id);
    List<Car> getAll();
}
