package com.exposit.carsharing.repository;

import com.exposit.carsharing.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Autowired
    User findByUsername(String username);
}
