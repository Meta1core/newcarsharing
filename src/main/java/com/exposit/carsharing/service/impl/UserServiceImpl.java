package com.exposit.carsharing.service.impl;


import com.exposit.carsharing.converter.ConverterUtil;
import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.model.payload.AccessTokenPayload;
import com.exposit.carsharing.model.payload.UserRegistrationPayload;
import com.exposit.carsharing.repository.RoleRepository;
import com.exposit.carsharing.repository.UserRepository;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.security.config.CustomException;
import com.exposit.carsharing.security.config.JwtTokenProvider;

import com.exposit.carsharing.service.UserService;
import com.sun.webkit.ContextMenu;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;
import sun.plugin2.message.ShowDocumentMessage;
import sun.plugin2.message.ShowStatusMessage;

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
            throw new CustomException("Password or Email or Username not entered", HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            user.setPassword(PasswordEncoder.encode(user.getPassword()));
            userRepository.save(ConverterUtil.convertToUser(user));
    }
    }

    public String signin(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && PasswordEncoder.matches(password, user.getPassword())) {
            return jwtTokenProvider.createToken(user.getId().toString());
        } else {
            throw new CustomException("Password or username invalid", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
