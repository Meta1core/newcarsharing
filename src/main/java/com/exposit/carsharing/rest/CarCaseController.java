package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.CarCase;
import com.exposit.carsharing.model.entity.Fuel;
import com.exposit.carsharing.service.CarCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/carcases")
public class CarCaseController {

    @Autowired
    private CarCaseService carCaseService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarCase> saveMark(@RequestBody @Valid CarCase carCase) {
        if (carCase == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.carCaseService.save(carCase);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarCase> updateCustomer(@RequestBody @Valid CarCase carCase) {

        if (carCase == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.carCaseService.save(carCase);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fuel> deleteCar(@PathVariable("id") Integer id) {
        CarCase carCase = this.carCaseService.getById(id);
        if (carCase == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.carCaseService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<CarCase>> getAllCars() {
        List<CarCase> carCase = this.carCaseService.getAll();
        if (carCase.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(carCase);
    }
}