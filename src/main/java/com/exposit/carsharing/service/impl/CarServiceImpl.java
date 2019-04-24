package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.repository.CarRepository;
import com.exposit.carsharing.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carrepository;
    @Override
    public Car getById(Integer id) {
        log.info("IN CarServiceImpl getById {}", id);
        return carrepository.getOne(id);
    }

    @Override
    public void save(Car car) {
        log.info("IN CarServiceImpl  save {}", car);
        carrepository.save(car);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN CarServiceImpl  delete {}", id);
        carrepository.deleteById(id);
    }

    @Override
    public List<Car> getAll() {
        log.info("IN CarServiceImpl  getAll");
        return carrepository.findAll();
    }
}
