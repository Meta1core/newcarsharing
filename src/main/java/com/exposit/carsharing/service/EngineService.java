package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.Engine;
import com.exposit.carsharing.model.entity.Mark;

import java.util.List;

public interface EngineService {
    Engine getById(Integer id);
    void save(Engine engine);
    void delete(Integer id);
    List<Engine> getAll();
}
