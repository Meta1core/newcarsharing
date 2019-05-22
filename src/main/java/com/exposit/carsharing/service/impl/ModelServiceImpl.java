package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.payload.ModelDTO;
import com.exposit.carsharing.model.payload.ModelEditDTO;
import com.exposit.carsharing.model.entity.Model;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.repository.ModelRepository;
import com.exposit.carsharing.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;
    @Autowired
    MarkRepository markRepository;

    @Override
    public Model getById(Integer id) {
        log.info("IN ModelServiceImpl getById {}", id);
        return modelRepository.getOne(id);
    }

    @Override
    public void save(ModelDTO modeldto) {
        log.info("IN ModelServiceImpl  save {}", modeldto);
        Model b = new Model();
        b.setModel(modeldto.getModel());
        b.setMarkbackend(markRepository.getOne(modeldto.getMarkID()));
        modelRepository.save(b);
    }

    @Override
    public void update(ModelEditDTO modeleditdto) {
        log.info("IN ModelServiceImpl  update {}", modeleditdto);
        Model b = new Model();
        b.setID_Model(modeleditdto.getId_Model());
        b.setModel(modeleditdto.getModel());
        b.setMarkbackend(markRepository.getOne(modeleditdto.getMarkID()));
        modelRepository.save(b);
    }

    @Override
    public void delete(Integer id) {
        log.info("IN ModelServiceImpl  delete {}", id);
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        log.info("IN ModelServiceImpl  getAll");
        return modelRepository.findAll();
    }
}
