package com.exposit.carsharing.model.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class UuidFromTokenPayload {
    public UUID id;
}
