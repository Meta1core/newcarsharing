package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer>
{
}
