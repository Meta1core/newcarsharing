package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.GearBox;
import com.exposit.carsharing.model.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearBoxRepository extends JpaRepository<GearBox, Integer>
{
}
