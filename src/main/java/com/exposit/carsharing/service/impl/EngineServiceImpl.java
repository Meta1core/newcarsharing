package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.Engine;
import com.exposit.carsharing.repository.EngineRepository;
import com.exposit.carsharing.service.EngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    EngineRepository engineRepository;

    @Override
    public Engine getById(Integer id) {
        log.info("IN EngineServiceImpl getById {}", id);
        return engineRepository.getOne(id);
    }

    @Override
    public void save(Engine engine) {
        log.info("IN EngineServiceImpl  save {}", engine);
        engineRepository.save(engine);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN EngineServiceImpl  delete {}", id);
        engineRepository.deleteById(id);
    }

    @Override
    public List<Engine> getAll() {
        log.info("IN EngineServiceImpl  getAll");
        return engineRepository.findAll();
    }
}
