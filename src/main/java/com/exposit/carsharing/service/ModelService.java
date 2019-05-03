package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.model.entity.Model;

import java.util.List;

public interface ModelService {
    Model getById(Integer id);
    void save(Model model);
    void delete(Integer id);
    List<Model> getAll();
}
