package com.exposit.carsharing.security.impl;

import com.exposit.carsharing.model.entity.Role;
import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


@Transactional
public class CarsharingUserDetails implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarsharingUserDetails.class);

    private UserRepository userRepository;

    public CarsharingUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                LOGGER.debug("user not found with the provided username");
                return null;
            }
            LOGGER.debug(" user from username " + user.toString());
            return org.springframework.security.core.userdetails.User//
                    .withUsername(username)//
                    .password(user.getPassword())//
                    .accountExpired(false)//
                    .accountLocked(false)//
                    .credentialsExpired(false)//
                    .disabled(false)//
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        LOGGER.debug("user authorities are " + authorities.toString());
        return authorities;
    }


}
