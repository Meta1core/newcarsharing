package com.exposit.carsharing.model.payload;

import lombok.Data;

@Data
public class AccessTokenPayload {
    public String accessToken;
    public Long userId;
    public String username;
    public String email;
    public String avatar;
    private String tokenType = "Bearer";
}
