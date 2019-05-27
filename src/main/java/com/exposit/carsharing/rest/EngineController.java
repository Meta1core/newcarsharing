package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.Engine;
import com.exposit.carsharing.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/engines")
public class EngineController {

    @Autowired
    private EngineService engineService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Engine> saveMark(@RequestBody @Valid Engine engine) {
        if (engine == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.engineService.save(engine);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Engine> updateCustomer(@RequestBody @Valid Engine engine) {

        if (engine == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.engineService.save(engine);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Engine> deleteCar(@PathVariable("id") Integer id) {
        Engine engine = this.engineService.getById(id);
        if (engine == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.engineService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<Engine>> getAllCars() {
        List<Engine> marks = this.engineService.getAll();
        if (marks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(marks);
    }
}