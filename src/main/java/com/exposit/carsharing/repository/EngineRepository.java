package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Integer> {
}
