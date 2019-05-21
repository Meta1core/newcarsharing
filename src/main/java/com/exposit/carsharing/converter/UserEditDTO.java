package com.exposit.carsharing.converter;

import lombok.Data;

@Data
public class UserEditDTO {
    private Long id;
    private String username;
    private String email;
    private String avatar;
    private String password;
}