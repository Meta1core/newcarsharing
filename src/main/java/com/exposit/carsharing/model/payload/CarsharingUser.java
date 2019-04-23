package com.exposit.carsharing.model.payload;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;
import java.util.Date;

@Table(name = "user")
@Data
public class CarsharingUser implements UserDetails {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Email(message = "Email should be valid")
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

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")

    private String address;


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
