package com.exposit.carsharing.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.hibernate.annotations.FetchMode.SELECT;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Convert(converter = UuidConverter.class)
    @Type(type = "uuid-char")
    private UUID id;

    private String username;

    private String password;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    @JsonBackReference
    @Fetch(value = SELECT)
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name="users_cars", joinColumns= {@JoinColumn(name="user_id")},  inverseJoinColumns= {@JoinColumn(name="car_id")})
    private List<Car> cars;


    private String avatar;

}
