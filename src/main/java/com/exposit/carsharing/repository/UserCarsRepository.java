package com.exposit.carsharing.repository;

import com.exposit.carsharing.model.entity.Requests;
import com.exposit.carsharing.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Requests, Integer> {
    List<Requests> findAllByUser(User user);
}
