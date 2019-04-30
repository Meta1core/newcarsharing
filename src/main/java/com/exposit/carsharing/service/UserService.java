package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;

public interface UserService {
    void save(UserRegistrationPayload user);
    String signin(String username, String password);
    User findByUsername(String username);
}
