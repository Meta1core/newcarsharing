package com.exposit.carsharing.rest;


import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserLoginPayload;
import com.exposit.carsharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserControllerv1 {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<User> registration(@RequestBody User user, BindingResult bindingResult) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody UserLoginPayload userLoginPayload) {
        String username = userLoginPayload.getUsername();
        String password = userLoginPayload.getPassword();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}