package com.exposit.carsharing.model.entity;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class UuidConverter implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(final UUID uuid) {
        return uuid.toString();
    }

    @Override
    public UUID convertToEntityAttribute(final String dbData) {
        if (!dbData.isEmpty() && !("null").equals(dbData)) {
            return UUID.fromString(dbData);
        }
        return null;
    }
}