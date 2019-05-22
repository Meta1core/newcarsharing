package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.MotorController;

import java.util.List;

public interface MotorControllerService {
    MotorController getById(Integer id);

    void save(MotorController motorController);

    void delete(Integer id);

    List<MotorController> getAll();
}
