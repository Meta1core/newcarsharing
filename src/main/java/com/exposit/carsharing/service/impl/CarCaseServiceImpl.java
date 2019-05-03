package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.CarCase;
import com.exposit.carsharing.model.entity.Engine;
import com.exposit.carsharing.repository.CarCaseRepository;
import com.exposit.carsharing.repository.EngineRepository;
import com.exposit.carsharing.service.CarCaseService;
import com.exposit.carsharing.service.EngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarCaseServiceImpl implements CarCaseService {

    @Autowired
    CarCaseRepository carCaseRepository;

    @Override
    public CarCase getById(Integer id) {
        log.info("IN CarCaseServiceImpl getById {}", id);
        return carCaseRepository.getOne(id);
    }

    @Override
    public void save(CarCase carCase) {
        log.info("IN CarCaseServiceImpl  save {}", carCase);
        carCaseRepository.save(carCase);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN CarCaseServiceImpl  delete {}", id);
        carCaseRepository.deleteById(id);
    }

    @Override
    public List<CarCase> getAll() {
        log.info("IN CarCaseServiceImpl  getAll");
        return carCaseRepository.findAll();
    }
}
