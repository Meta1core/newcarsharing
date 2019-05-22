package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.GearBox;
import com.exposit.carsharing.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/gearboxes")
public class GearBoxController {

    @Autowired
    private GearBoxService gearBoxService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GearBox> saveMark(@RequestBody @Valid GearBox gearBox) {
        if (gearBox == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.gearBoxService.save(gearBox);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GearBox> updateCustomer(@RequestBody @Valid GearBox gearBox) {

        if (gearBox == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.gearBoxService.save(gearBox);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GearBox> deleteCar(@PathVariable("id") Integer id) {
        GearBox gearBox = this.gearBoxService.getById(id);
        if (gearBox == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.gearBoxService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<GearBox>> getAllCars() {
        List<GearBox> marks = this.gearBoxService.getAll();
        if (marks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(marks);
    }
}