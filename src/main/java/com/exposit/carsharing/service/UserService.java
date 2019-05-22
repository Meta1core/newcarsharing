package com.exposit.carsharing.service;

import com.exposit.carsharing.model.payload.UserEditDTO;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void save(User user);

    void signup(UserRegistrationPayload user);

    AccessTokenPayload signin(String username, String password);

    User search(String username);

    User getUserByUUID(UUID id);

    void update(UserEditDTO user);

    void deleteUser(UUID id);

    List<User> getAll();
}
