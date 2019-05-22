package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.MotorController;
import com.exposit.carsharing.repository.MotorControllerRepository;
import com.exposit.carsharing.service.MotorControllerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MotorControllerServiceImpl implements MotorControllerService {

    @Autowired
    MotorControllerRepository markRepository;

    @Override
    public MotorController getById(Integer id) {
        log.info("IN MotorControllerServiceImpl getById {}", id);
        return markRepository.getOne(id);
    }

    @Override
    public void save(MotorController modelcontroller) {
        log.info("IN MotorControllerServiceImpl  save {}", modelcontroller);
        markRepository.save(modelcontroller);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN MotorControllerServiceImpl  delete {}", id);
        markRepository.deleteById(id);
    }

    @Override
    public List<MotorController> getAll() {
        log.info("IN MotorControllerServiceImpl  getAll");
        return markRepository.findAll();
    }
}
