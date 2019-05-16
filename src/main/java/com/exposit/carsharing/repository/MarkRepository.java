package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Integer>
{
}
