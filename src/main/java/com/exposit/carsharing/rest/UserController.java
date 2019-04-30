package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserLoginPayload;
import com.exposit.carsharing.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
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

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String login(@RequestBody UserLoginPayload userLoginPayload) {
        if (userLoginPayload == null) {
           log.error(HttpStatus.BAD_REQUEST.toString());
        }
        return userService.signin(userLoginPayload.getUsername(),userLoginPayload.getPassword());
    }

}