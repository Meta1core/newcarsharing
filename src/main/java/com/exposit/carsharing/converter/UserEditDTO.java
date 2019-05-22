package com.exposit.carsharing.converter;

import lombok.Data;

import java.util.UUID;

@Data
public class UserEditDTO {
    private UUID id;
    private String username;
    private String email;
    private String avatar;
    private String password;
}