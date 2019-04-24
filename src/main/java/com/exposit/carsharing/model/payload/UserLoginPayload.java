package com.exposit.carsharing.model.payload;

import lombok.Data;
import javax.validation.constraints.Size;

@Data
public class UserLoginPayload {

    @Size(min = 4, max = 14, message
            = "Username must be between 4 and 14 characters")
    private String username;

    @Size(min = 5, max = 15, message
            = "Password must be between 5 and 15 characters")
    private String password;
}
