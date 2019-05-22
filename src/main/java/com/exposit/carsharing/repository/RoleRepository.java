package com.exposit.carsharing.repository;

import com.exposit.carsharing.model.entity.Role;
import com.exposit.carsharing.model.entity.RoleName;
import com.exposit.carsharing.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(RoleName name);
}
