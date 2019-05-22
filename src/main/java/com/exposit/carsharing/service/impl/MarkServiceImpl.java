package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.service.MarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    MarkRepository markRepository;

    @Override
    public Mark getById(Integer id) {
        log.info("IN MarkServiceImpl getById {}", id);
        return markRepository.getOne(id);
    }

    @Override
    public void save(Mark mark) {
        log.info("IN MarkServiceImpl  save {}", mark);
        markRepository.save(mark);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN MarkServiceImpl  delete {}", id);
        markRepository.deleteById(id);
    }

    @Override
    public List<Mark> getAll() {
        log.info("IN MarkServiceImpl  getAll");
        return markRepository.findAll();
    }
}
