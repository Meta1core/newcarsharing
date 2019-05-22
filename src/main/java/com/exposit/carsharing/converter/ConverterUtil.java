package com.exposit.carsharing.converter;

import com.exposit.carsharing.model.entity.Role;
import com.exposit.carsharing.model.entity.RoleName;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import com.exposit.carsharing.repository.RoleRepository;
import com.exposit.carsharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {
    @Autowired
    RoleRepository roleRepository;

    public static User convertToUser(UserRegistrationPayload payload, String password, List<Role> roles) {
        final User user = new User();
        user.setEmail(payload.getEmail());
        user.setUsername(payload.getUsername());
        user.setPassword(password);
        user.setRoles(roles);
        return user;
    }
}