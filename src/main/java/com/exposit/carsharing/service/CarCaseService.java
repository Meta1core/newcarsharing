package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.CarCase;
import com.exposit.carsharing.model.entity.Fuel;

import java.util.List;

public interface CarCaseService {
    CarCase getById(Integer id);
    void save(CarCase carCase);
    void delete(Integer id);
    List<CarCase> getAll();
}
