package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.Fuel;

import java.util.List;

public interface FuelService {
    Fuel getById(Integer id);

    void save(Fuel fuel);

    void delete(Integer id);

    List<Fuel> getAll();
}
