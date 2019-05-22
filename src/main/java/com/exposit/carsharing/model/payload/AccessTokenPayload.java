package com.exposit.carsharing.model.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class AccessTokenPayload {
    public String accessToken;
}
