package com.exposit.carsharing.service;

import com.exposit.carsharing.model.payload.ModelDTO;
import com.exposit.carsharing.model.payload.ModelEditDTO;
import com.exposit.carsharing.model.entity.Model;

import java.util.List;

public interface ModelService {
    Model getById(Integer id);

    void save(ModelDTO model);

    void update(ModelEditDTO model);

    void delete(Integer id);

    List<Model> getAll();
}
