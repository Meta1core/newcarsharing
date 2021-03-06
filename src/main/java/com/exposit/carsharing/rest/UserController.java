package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserEditDTO;
import com.exposit.carsharing.model.payload.UserLoginPayload;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import com.exposit.carsharing.security.jwt.JwtTokenProvider;
import com.exposit.carsharing.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@RequestBody UserRegistrationPayload userRegistrationPayload) {
        if (userRegistrationPayload == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        userService.signup(userRegistrationPayload);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/login")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public AccessTokenPayload login(@RequestBody @Valid UserLoginPayload userLoginPayload) {
        if (userLoginPayload == null) {
            log.error(HttpStatus.BAD_REQUEST.toString());
        }
        return userService.signin(userLoginPayload.getUsername(), userLoginPayload.getPassword());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") UUID userid) {
        if (userid == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = this.userService.getUserByUUID(userid);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") UUID id) {
        User user = this.userService.getUserByUUID(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping()
    public ResponseEntity<User> updateUser(@RequestBody UserEditDTO user) {

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

    @PostMapping(value = "/getfromtoken")
    public ResponseEntity<User> getUserFromToken(@RequestBody String token) {
        if (jwtTokenProvider.validateToken(token)) {
            if (token == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(this.userService.GetUserFromToken(token), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}