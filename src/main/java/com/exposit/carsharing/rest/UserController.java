package com.exposit.carsharing.rest;


import com.exposit.carsharing.converter.UserEditDTO;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserLoginPayload;
import com.exposit.carsharing.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody UserRegistrationPayload userRegistrationPayload) {
        if (userRegistrationPayload == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userService.save(userRegistrationPayload);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/login")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public AccessTokenPayload login(@RequestBody UserLoginPayload userLoginPayload) {
        if (userLoginPayload == null) {
           log.error(HttpStatus.BAD_REQUEST.toString());
        }
        return userService.signin(userLoginPayload.getUsername(),userLoginPayload.getPassword());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<User> getUser(@PathVariable("id") Long userid) {
        if (userid == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.getUser(userid);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id)
    {
        User user = this.userService.getUser(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateCustomer(@RequestBody @Valid UserEditDTO user) {

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.userService.update(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(users);
    }
}