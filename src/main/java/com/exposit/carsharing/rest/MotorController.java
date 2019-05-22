package com.exposit.carsharing.rest;


import com.exposit.carsharing.service.MotorControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/motorcontrollers")
public class MotorController {

    @Autowired
    private MotorControllerService motorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MotorController> saveMark(@RequestBody @Valid com.exposit.carsharing.model.entity.MotorController motor) {
        if (motor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.motorService.save(motor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MotorController> updateCustomer(@RequestBody @Valid com.exposit.carsharing.model.entity.MotorController motor) {

        if (motor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.motorService.save(motor);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<com.exposit.carsharing.model.entity.MotorController> deleteCar(@PathVariable("id") Integer id) {
        com.exposit.carsharing.model.entity.MotorController motorController = this.motorService.getById(id);
        if (motorController == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.motorService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<com.exposit.carsharing.model.entity.MotorController>> getAllCars() {
        List<com.exposit.carsharing.model.entity.MotorController> models = this.motorService.getAll();
        if (models.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(models);
    }
}