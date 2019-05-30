package com.exposit.carsharing.service.impl;


import com.exposit.carsharing.converter.ConverterUtil;
import com.exposit.carsharing.model.entity.Role;
import com.exposit.carsharing.model.entity.RoleName;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.exception.CarsharingException;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserEditDTO;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import com.exposit.carsharing.model.payload.UuidFromTokenPayload;
import com.exposit.carsharing.repository.RoleRepository;
import com.exposit.carsharing.repository.UserRepository;
import com.exposit.carsharing.security.jwt.JwtTokenProvider;
import com.exposit.carsharing.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder PasswordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private RoleRepository roleRepository;

    @Override
    public void signup(UserRegistrationPayload payload) {
        if (payload.getPassword() == null || payload.getPassword() == "" || payload.getEmail() == null || payload.getEmail() == "" || payload.getUsername() == null || payload.getUsername() == "") {
            throw new CarsharingException("Password or Email or Username not entered", HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            log.info("IN UserServiceImpl  Registration {}", payload.getUsername());
            save(ConverterUtil.convertToUser(payload, PasswordEncoder.encode(payload.getPassword()), payload.getRoles() != null ? getPersistedRoles(payload.getRoles()) : null));
        }
    }

    @Override
    public void save(User user) {
        log.info("IN UserServiceImpl  save {}", user.getUsername());
        userRepository.save(user);
    }


    @Override
    public void update(UserEditDTO user) {
        User b = new User();
        b.setId(user.getId());
        b.setUsername(user.getUsername());
        b.setEmail(user.getEmail());
        b.setAvatar(user.getAvatar());
        b.setPassword(user.getPassword());
        b.setIdennomer(user.getIdennomer());
        b.setDateprav(user.getDateprav());
        b.setSrokprav(user.getSrokprav());
        b.setMobilenumber(user.getMobileNumber());
        b.setNprav(user.getNprav());
        b.setSprav(user.getSprav());
        b.setKategprav(user.getKategprav());
        b.setSPassport(user.getSPassport());
        b.setKPassport(user.getKPassport());
        b.setNPassport(user.getNPassport());
        b.setRoles(user.getRoles() != null ? getPersistedRoles(user.getRoles()) : null);
        userRepository.save(b);
        log.info("IN UserServiceImpl  update {}", user.getId());
    }

    public AccessTokenPayload signin(String username, String password) {
        User user = userRepository.findByUsername(username);
        AccessTokenPayload tokenpayload = new AccessTokenPayload();
        if (user != null && PasswordEncoder.matches(password, user.getPassword())) {
            tokenpayload.accessToken = jwtTokenProvider.createToken(user.getId().toString());
            log.info("IN UserServiceImpl LOGIN {}", user.getId());
            return tokenpayload;
        } else {
            throw new CarsharingException("Password or username invalid", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CarsharingException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    @Override
    public User GetUserFromToken(String token) {
        log.info("IN UserServiceImpl  GetUUIDFromToken {}");
        UUID tokenfromid = jwtTokenProvider.getUUIDFromToken(token);
        return userRepository.findById(tokenfromid).orElse(null);
    }

    @Override
    public User getUserByUUID(UUID id) {
        log.info("IN UserServiceImpl getById {}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(UUID id) {
        log.info("IN UserServiceImpl  delete {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        log.info("IN UserServiceImpl  getAll");
        return userRepository.findAll();
    }

    private List<Role> getPersistedRoles(final List<RoleName> roles) {
        return roles
                .stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .stream()
                        .findFirst()
                        .orElseGet(() -> {
                            final Role role = Role.builder().name(roleName).build();
                            roleRepository.save(role);
                            return role;
                        }))
                .collect(Collectors.toList());
    }


}
