package com.exposit.carsharing.rest;


import com.exposit.carsharing.converter.ModelDTO;
import com.exposit.carsharing.converter.ModelEditDTO;
import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.model.entity.Model;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.repository.ModelRepository;
import com.exposit.carsharing.service.MarkService;
import com.exposit.carsharing.service.ModelService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModelDTO> saveMark(@RequestBody @Valid ModelDTO model) {
        if (model == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.modelService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<ModelEditDTO> updateCustomer(@RequestBody @Valid ModelEditDTO model) {
        if (model == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.modelService.update(model);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Model> deleteCar(@PathVariable("id") Integer id) {
        Model model = this.modelService.getById(id);
        if (model == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.modelService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<Model>> getAllCars() {
        List<Model> models = this.modelService.getAll();
        if (models.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(models);
    }
}