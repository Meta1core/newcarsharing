package com.exposit.carsharing.service.impl;


import com.exposit.carsharing.repository.RoleRepository;
import com.exposit.carsharing.repository.UserRepository;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.security.config.CustomException;
import com.exposit.carsharing.security.config.JwtTokenProvider;

import com.exposit.carsharing.service.UserService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;
@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findAll());
        userRepository.save(user);
    }

    public String signin(String username, String password) {
        try {
           User dbpassword =  userRepository.findByUsername(username);
            if (!bCryptPasswordEncoder.matches(password, dbpassword.getPassword())) {
                log.error("Incorrect password for user with email={0} and ID={1}",
                        dbpassword.getEmail(), dbpassword.getId());
            }
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
        }   catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
