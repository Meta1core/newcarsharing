package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.payload.CarDTO;
import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/cars")
@AllArgsConstructor
public class CarController {

    private CarService carservice;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getCustomer(@PathVariable("id") Integer customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Car customer = carservice.getById(customerId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarDTO> saveCar(@RequestBody @Valid CarDTO car) {
        if (car == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        carservice.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> updateCustomer(@RequestBody @Valid CarDTO car) {

        if (car == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        carservice.update(car);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id) {
        Car car = carservice.getById(id);
        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        carservice.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carservice.getAll());
    }
}