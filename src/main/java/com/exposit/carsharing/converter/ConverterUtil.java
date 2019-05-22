package com.exposit.carsharing.converter;

import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;

public class ConverterUtil {
    public static User convertToUser(UserRegistrationPayload payload) {
        final User user = new User();
        user.setEmail(payload.getEmail());
        user.setPassword(payload.getPassword());
        return user;
    }
}
