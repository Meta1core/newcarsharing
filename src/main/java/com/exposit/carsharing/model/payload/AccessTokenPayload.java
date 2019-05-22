package com.exposit.carsharing.model.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class AccessTokenPayload {
    public String accessToken;
    public UUID userId;
    public String username;
    public String email;
    public String avatar;
    private String tokenType = "Bearer";
}
