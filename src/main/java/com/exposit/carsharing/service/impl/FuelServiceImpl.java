package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.Engine;
import com.exposit.carsharing.model.entity.Fuel;
import com.exposit.carsharing.repository.EngineRepository;
import com.exposit.carsharing.repository.FuelRepository;
import com.exposit.carsharing.service.EngineService;
import com.exposit.carsharing.service.FuelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    FuelRepository fuelRepository;

    @Override
    public Fuel getById(Integer id) {
        log.info("IN FuelServiceImpl getById {}", id);
        return fuelRepository.getOne(id);
    }

    @Override
    public void save(Fuel fuel) {
        log.info("IN FuelServiceImpl  save {}", fuel);
        fuelRepository.save(fuel);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN FuelServiceImpl  delete {}", id);
        fuelRepository.deleteById(id);
    }

    @Override
    public List<Fuel> getAll() {
        log.info("IN FuelServiceImpl  getAll");
        return fuelRepository.findAll();
    }
}
