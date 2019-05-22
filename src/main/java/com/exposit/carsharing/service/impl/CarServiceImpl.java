package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.payload.CarDTO;
import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.repository.*;
import com.exposit.carsharing.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carrepository;
    @Autowired
    MarkRepository markRepository;
    @Autowired
    ModelRepository modelRepository;
    @Autowired
    EngineRepository engineRepository;
    @Autowired
    CarCaseRepository carCaseRepository;
    @Autowired
    GearBoxRepository gearBoxRepository;
    @Autowired
    FuelRepository fuelRepository;
    @Autowired
    MotorControllerRepository motorControllerRepository;

    @Override
    public Car getById(Integer id) {
        log.info("IN CarServiceImpl getById {}", id);
        return carrepository.getOne(id);
    }

    @Override
    public void save(CarDTO modeldto) {
        log.info("IN CarServiceImpl  save {}", modeldto);
        Car b = new Car();
        b.setMark(markRepository.getOne(modeldto.getMarkID()));
        b.setModel(modelRepository.getOne(modeldto.getModelID()));
        b.setEngine(engineRepository.getOne(modeldto.getEngineID()));
        b.setFuel(fuelRepository.getOne(modeldto.getFuelID()));
        b.setCarcase(carCaseRepository.getOne(modeldto.getCarcaseID()));
        b.setGearbox(gearBoxRepository.getOne(modeldto.getGearboxID()));
        b.setMotorController(motorControllerRepository.getOne(modeldto.getMotorcontrollerID()));
        b.setCalendar(modeldto.getCalendar());
        b.setCarNumber(modeldto.getCarnumber());
        b.setConsumption(modeldto.getConsumption());
        b.setLocation(modeldto.getLocation());
        b.setGiphy(modeldto.getGif());
        b.setNumberPlace(modeldto.getNumberplace());
        b.setItems(modeldto.getItems());
        b.setInsurance(modeldto.getInsurance());
        b.setStatus(modeldto.getStatus());
        b.setPrice(modeldto.getPrice());
        b.setMileage(modeldto.getMileage());
        b.setText(modeldto.getText());
        b.setYear(modeldto.getYear());
        carrepository.save(b);
    }

    @Override
    public void update(CarDTO modeleditdto) {
        log.info("IN CarServiceImpl  update {}", modeleditdto);
        Car b = new Car();
        b.setID(modeleditdto.getId());
        b.setMark(markRepository.getOne(modeleditdto.getMarkID()));
        b.setModel(modelRepository.getOne(modeleditdto.getModelID()));
        b.setEngine(engineRepository.getOne(modeleditdto.getEngineID()));
        b.setFuel(fuelRepository.getOne(modeleditdto.getFuelID()));
        b.setCarcase(carCaseRepository.getOne(modeleditdto.getCarcaseID()));
        b.setGearbox(gearBoxRepository.getOne(modeleditdto.getGearboxID()));
        b.setMotorController(motorControllerRepository.getOne(modeleditdto.getMotorcontrollerID()));
        b.setCalendar(modeleditdto.getCalendar());
        b.setCarNumber(modeleditdto.getCarnumber());
        b.setConsumption(modeleditdto.getConsumption());
        b.setLocation(modeleditdto.getLocation());
        b.setGiphy(modeleditdto.getGif());
        b.setNumberPlace(modeleditdto.getNumberplace());
        b.setItems(modeleditdto.getItems());
        b.setInsurance(modeleditdto.getInsurance());
        b.setStatus(modeleditdto.getStatus());
        b.setPrice(modeleditdto.getPrice());
        b.setMileage(modeleditdto.getMileage());
        b.setText(modeleditdto.getText());
        b.setYear(modeleditdto.getYear());
        carrepository.save(b);
    }

    @Override
    public void delete(Integer id) {
        log.info("IN CarServiceImpl  delete {}", id);
        carrepository.deleteById(id);
    }

    @Secured("ROLE_ADMIN")
    @Override
    public List<Car> getAll() {
        log.info("IN CarServiceImpl  getAll");
        return carrepository.findAll();
    }
}
