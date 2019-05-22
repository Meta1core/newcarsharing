package com.exposit.carsharing.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

@Data
@Builder
@AllArgsConstructor
public class CarsharingUserDetails implements UserDetails {

    private final UUID id;

    private final String email;

    private final Collection<String> roles;

    private final Collection<GrantedAuthority> authorities;

    public CarsharingUserDetails(final UUID id, final String email, final List<String> roles) {
        this.id = id;
        this.email = email;
        this.roles = roles;

        if (roles != null) {
            authorities = roles.stream().map(x -> "ROLE_" + x)
                    .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        } else {
            authorities = new ArrayList<>();
        }
    }

    public static class CarsharingUserDetailsBuilder {

        public CarsharingUserDetails.CarsharingUserDetailsBuilder roles(final Collection<String> roles) {
            this.roles = roles;
            if (!CollectionUtils.isEmpty(roles)) {
                this.authorities = roles.stream()
                        .map(x -> "ROLE_" + x)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
            }
            return this;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}