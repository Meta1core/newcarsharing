package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.Fuel;
import com.exposit.carsharing.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/fuels")
public class FuelController {

    @Autowired
    private FuelService fuelService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fuel> saveMark(@RequestBody @Valid Fuel fuel) {
        if (fuel == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.fuelService.save(fuel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fuel> updateCustomer(@RequestBody @Valid Fuel fuel) {

        if (fuel == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.fuelService.save(fuel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Fuel> deleteCar(@PathVariable("id") Integer id) {
        Fuel fuel = this.fuelService.getById(id);
        if (fuel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.fuelService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<Fuel>> getAllCars() {
        List<Fuel> fuel = this.fuelService.getAll();
        if (fuel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(fuel);
    }
}