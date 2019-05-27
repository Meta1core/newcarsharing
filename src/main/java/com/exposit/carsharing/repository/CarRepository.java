package com.exposit.carsharing.repository;


import com.exposit.carsharing.model.entity.Car;
import com.exposit.carsharing.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByUser(User user);
}
