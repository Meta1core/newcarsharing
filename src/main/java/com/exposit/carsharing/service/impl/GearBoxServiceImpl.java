package com.exposit.carsharing.service.impl;

import com.exposit.carsharing.model.entity.GearBox;
import com.exposit.carsharing.model.entity.Mark;
import com.exposit.carsharing.repository.GearBoxRepository;
import com.exposit.carsharing.repository.MarkRepository;
import com.exposit.carsharing.service.GearBoxService;
import com.exposit.carsharing.service.MarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GearBoxServiceImpl implements GearBoxService {

    @Autowired
    GearBoxRepository gearBoxRepository;

    @Override
    public GearBox getById(Integer id) {
        log.info("IN GearBoxServiceImpl getById {}", id);
        return gearBoxRepository.getOne(id);
    }

    @Override
    public void save(GearBox gearBox) {
        log.info("IN GearBoxServiceImpl  save {}", gearBox);
        gearBoxRepository.save(gearBox);

    }

    @Override
    public void delete(Integer id) {
        log.info("IN GearBoxServiceImpl  delete {}", id);
        gearBoxRepository.deleteById(id);
    }

    @Override
    public List<GearBox> getAll() {
        log.info("IN GearBoxServiceImpl  getAll");
        return gearBoxRepository.findAll();
    }
}
