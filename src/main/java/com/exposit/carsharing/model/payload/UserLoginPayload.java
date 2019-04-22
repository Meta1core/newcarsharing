package com.exposit.carsharing.model.payload;

import lombok.Data;

import javax.persistence.*;

@Table(name = "user")
@Data
public class UserLoginPayload {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
