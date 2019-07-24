package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.model.entity.Requests;
import com.exposit.carsharing.model.payload.CarDTO;
import com.exposit.carsharing.model.payload.RentCarDTO;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.repository.RequestRepository;
import com.exposit.carsharing.service.MarkService;
import com.exposit.carsharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/requests")
public class RequestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestRepository requestRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<Requests>> getAllRequests() {
        return ResponseEntity.ok(userService.getAllRequests());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> updateRequest(@RequestBody @Valid RentCarDTO request) {
        userService.updateRequest(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> getRequest(@PathVariable("id") Integer requestID) {
        if (requestID == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Requests request = requestRepository.findById(requestID).orElse(null);

        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(request, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteRequestCarsByUser(@PathVariable("id") Integer id) {
       requestRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}