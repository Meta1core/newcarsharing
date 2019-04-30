package com.exposit.carsharing.model.payload;

import com.exposit.carsharing.model.entity.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserRegistrationPayload {

    @Size(min = 4, max = 14, message
            = "Username must be between 4 and 14 characters")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 5, max = 15, message
            = "Password must be between 5 and 15 characters")
    private String password;

}
