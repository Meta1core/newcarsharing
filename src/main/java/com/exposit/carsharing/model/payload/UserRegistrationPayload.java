package com.exposit.carsharing.model.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Data

public class UserRegistrationPayload {

    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 5, max = 15, message
            = "Password must be between 5 and 15 characters")
    private String password;

    private List<String> roles;
}
