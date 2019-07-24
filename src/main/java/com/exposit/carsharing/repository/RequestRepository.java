package com.exposit.carsharing.repository;

import com.exposit.carsharing.model.entity.Role;
import com.exposit.carsharing.model.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(RoleName name);
}
