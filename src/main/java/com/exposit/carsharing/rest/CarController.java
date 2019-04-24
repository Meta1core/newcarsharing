package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")

public class CarController {

    @Autowired
    private CarService carservice;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<Car> getCar(@PathVariable("id") Integer carId) {
        if (carId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Car car = this.carservice.getById(carId);
        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Car> saveCar(@RequestBody @Valid Car car) {
        if (car == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.carservice.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Car> updateCustomer(@RequestBody @Valid Car car) {

        if (car == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.carservice.save(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id) {
        Car car = this.carservice.getById(id);
        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.carservice.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = this.carservice.getAll();
        if (cars.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}