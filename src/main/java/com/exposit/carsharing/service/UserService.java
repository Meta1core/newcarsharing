package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
