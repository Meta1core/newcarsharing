package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.service.CarService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService carservice;

   @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public ResponseEntity<Car> getCustomer(@PathVariable("id") Integer customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Car customer = this.carservice.getById(customerId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> saveCar(@RequestBody @Valid Car car) {
        if (car == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.carservice.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> updateCustomer(@RequestBody @Valid Car car) {

        if (car == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.carservice.save(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id)
    {
        Car car = this.carservice.getById(id);
        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.carservice.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = this.carservice.getAll();
        if (cars.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(cars);
    }
}