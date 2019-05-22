package com.exposit.carsharing.service.impl;


import com.exposit.carsharing.converter.ConverterUtil;
import com.exposit.carsharing.converter.UserEditDTO;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import com.exposit.carsharing.repository.UserRepository;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.exception.CarsharingException;
import com.exposit.carsharing.security.jwt.JwtTokenProvider;

import com.exposit.carsharing.service.UserService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder PasswordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public void save(UserRegistrationPayload user) {
        if (user.getPassword() == null || user.getPassword() == "" || user.getEmail() == null || user.getEmail() == ""|| user.getUsername() == null || user.getUsername() == "" ) {
            throw new CarsharingException("Password or Email or Username not entered", HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            log.info("IN UserServiceImpl  Registration {}", user.getUsername());
            user.setPassword(PasswordEncoder.encode(user.getPassword()));
            userRepository.save(ConverterUtil.convertToUser(user));
    }
    }

    @Override
    public void update(UserEditDTO user) {
            User b = new User();
            b.setId(user.getId());
            b.setUsername(user.getUsername());
            b.setEmail(user.getEmail());
        b.setAvatar(user.getAvatar());
        b.setPassword(user.getPassword());
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
    public User getUserByUUID(UUID id) {
        log.info("IN UserServiceImpl getById {}", id);
        return userRepository.getOne(id);
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


}
