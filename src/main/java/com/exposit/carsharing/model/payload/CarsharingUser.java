package com.exposit.carsharing.model.payload;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Table(name = "user")
@Data
public class CarsharingUser implements UserDetails {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "LastName")
    private String lastname;

    @Column(name = "FirstName")
    private String firstname;

    @Column(name = "PasswordSeries")
    private String passwordseries;

    @Column(name = "PasswordNumber")
    private Integer passwordnumber;

    @Column(name = "PasswordDate")
    @Temporal(TemporalType.DATE)
    private Date passworddate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
