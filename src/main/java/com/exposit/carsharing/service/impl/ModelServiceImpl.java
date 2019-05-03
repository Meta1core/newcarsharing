package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.model.entity.Model;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.repository.ModelRepository;
import com.exposit.carsharing.service.MarkService;
import com.exposit.carsharing.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository markRepository;

    @Override
    public Model getById(Integer id) {
        log.info("IN ModelServiceImpl getById {}", id);
        return markRepository.getOne(id);
    }

    @Override
    public void save(Model mark) {
        log.info("IN ModelServiceImpl  save {}", mark);
        markRepository.save(mark);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN ModelServiceImpl  delete {}", id);
        markRepository.deleteById(id);
    }

    @Override
    public List<Model> getAll() {
        log.info("IN ModelServiceImpl  getAll");
        return markRepository.findAll();
    }
}
