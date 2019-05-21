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
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="role_name")
  private String roleName;

  @Column(name="description")
  private String description;

}