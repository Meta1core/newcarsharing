package com.exposit.carsharing.model.payload;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "user")
@Data
public class UserLoginPayload {

    @Size(min = 4, max = 14, message
            = "Username must be between 4 and 14 characters")
    @Column(name = "username")
    private String username;

    @Size(min = 5, max = 15, message
            = "Password must be between 5 and 15 characters")
    @Column(name = "password")
    private String password;
}
