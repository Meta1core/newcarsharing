package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.payload.ModelDTO;
import com.exposit.carsharing.model.payload.ModelEditDTO;
import com.exposit.carsharing.model.entity.Model;
import com.exposit.carsharing.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModelDTO> saveMark(@RequestBody @Valid ModelDTO model) {
        if (model == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.modelService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping()
    public ResponseEntity<ModelEditDTO> updateCustomer(@RequestBody @Valid ModelEditDTO model) {
        if (model == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.modelService.update(model);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Model> deleteCar(@PathVariable("id") Integer id) {
        Model model = this.modelService.getById(id);
        if (model == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.modelService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<Model>> getAllCars() {
        List<Model> models = this.modelService.getAll();
        if (models.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(models);
    }
}