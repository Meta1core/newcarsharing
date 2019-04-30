package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String role;

  @ManyToMany(mappedBy = "roles")
  private List<User> users;

}