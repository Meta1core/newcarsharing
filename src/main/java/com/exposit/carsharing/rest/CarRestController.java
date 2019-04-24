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
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders ="*")
@RequestMapping("/cars/" )

public class CarRestController {
    @Autowired
    private CarService carservice;
    @RequestMapping(value = "{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Access-Control-Allow-Origin")

    public ResponseEntity<Car> getCar(@PathVariable("id") Integer carId) {
        if (carId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Car car = this.carservice.getById(carId);
        if (car == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Access-Control-Allow-Origin")
    public ResponseEntity<Car> saveCar(@RequestBody @Valid Car car){
        if(car == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.carservice.save(car);
        return new ResponseEntity<>(car,HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Car> updateCustomer(@RequestBody @Valid Car car, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (car == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.carservice.save(car);

        return new ResponseEntity<>(car, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Access-Control-Allow-Origin")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id)
    {
        Car car = this.carservice.getById(id);
        if (car == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.carservice.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Access-Control-Allow-Origin")
    public ResponseEntity<List<Car>> getAllCars()
    {
        List<Car> cars = this.carservice.getAll();
        if (cars.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }
}