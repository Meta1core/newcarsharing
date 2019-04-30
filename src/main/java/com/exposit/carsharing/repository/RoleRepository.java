package com.exposit.carsharing.repository;

import com.exposit.carsharing.model.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
