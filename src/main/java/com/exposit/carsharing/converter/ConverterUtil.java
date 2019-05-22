package com.exposit.carsharing.converter;

import com.exposit.carsharing.model.entity.Role;
import com.exposit.carsharing.model.entity.RoleName;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {
    public static User convertToUser(UserRegistrationPayload payload) {
        final User user = new User();
        user.setEmail(payload.getEmail());
        user.setUsername(payload.getUsername());
        user.setPassword(payload.getPassword());

        List<Role> roles = new ArrayList<>();
        for (String s : payload.getRoles()){
            Role role = new Role();
            role.setRole(RoleName.valueOf(s));

            roles.add(role);
        }
        user.setRoles(roles);

        return user;
    }
}
