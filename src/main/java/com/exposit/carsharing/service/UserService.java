package com.exposit.carsharing.service;

import com.exposit.carsharing.converter.UserEditDTO;
import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;

import java.util.List;

public interface UserService {
    void save(UserRegistrationPayload user);
    AccessTokenPayload signin(String username, String password);
    User findByUsername(String username);
    User getUser(Long id);
    void update(UserEditDTO user);
    void deleteUser(Long id);
    List<User> getAll();
}
