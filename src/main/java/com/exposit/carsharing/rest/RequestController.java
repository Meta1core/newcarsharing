package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/marks")
public class MarkController {

    @Autowired
    private MarkService markService;

    @Autowired
    private MarkRepository markRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mark> saveMark(@RequestBody @Valid Mark mark) {
        if (mark == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.markService.save(mark);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mark> updateCustomer(@RequestBody @Valid Mark mark) {

        if (mark == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.markService.save(mark);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Mark> deleteCar(@PathVariable("id") Integer id) {
        Mark mark = this.markService.getById(id);
        if (mark == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.markService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<Mark>> getAllCars() {
        List<Mark> marks = this.markService.getAll();
        if (marks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(marks);
    }
}