package com.exposit.carsharing.security.jwt;

import com.exposit.carsharing.model.entity.User;
import com.exposit.carsharing.model.exception.CarsharingException;
import com.exposit.carsharing.security.CarsharingUserDetails;
import com.exposit.carsharing.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    @Autowired
    private UserService userService;

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String userId) {

        final Claims claims = Jwts.claims().setSubject(userId);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        try {
            User user = userService.getUserByUUID(getUUIDFromToken(token));
            if (user != null) {
                final UserDetails userDetails = CarsharingUserDetails.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .roles(user.getRoles() != null ? user.getRoles()
                                .stream()
                                .map(role -> role.getName().name())
                                .collect(Collectors.toList()) : null)
                        .build();

                return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
            }
        } catch (final CarsharingException e) {
            log.error("Impossible to get user info with supplied token {}: http code={}, message={}",
                    e.getMessage(), e);
            throw e;
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }

        return null;
    }

    public UUID getUUIDFromToken(String token) {
        System.out.println(UUID.fromString(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject()));
        return UUID.fromString(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new CarsharingException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
