package com.exposit.carsharing.web;


import com.exposit.carsharing.model.User;
import com.exposit.carsharing.model.UserLoginPayload;
import com.exposit.carsharing.service.UserService;
import com.exposit.carsharing.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;


@Controller
public class UserControllerv1{

    @Autowired
    private UserService userService;


    @Autowired
    private UserValidator userValidator;


    private UserLoginPayload userLoginPayload;



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity <User>  registration(@RequestBody @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.save(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity <UserLoginPayload> login(@RequestBody UserLoginPayload userLoginPayload) {
        String username = userLoginPayload.getUsername();
        String password = userLoginPayload.getPassword();

                return new ResponseEntity<>( HttpStatus.OK);
    }

}