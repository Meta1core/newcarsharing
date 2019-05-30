package com.exposit.carsharing.model.payload;

import com.exposit.carsharing.model.entity.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Data
public class UserEditDTO {
    private UUID id;
    private String username;
    private String email;
    private String avatar;
    private String password;
    private Date dateprav;
    private Date srokprav;
    private String kategprav;
    private String sprav;
    private String nprav;
    private String mobileNumber;
    private String idennomer;

    private String SPassport;
    private String NPassport;
    private String KPassport;
    private List<RoleName> roles;
}