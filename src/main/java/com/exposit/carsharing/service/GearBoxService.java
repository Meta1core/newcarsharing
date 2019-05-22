package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.GearBox;

import java.util.List;

public interface GearBoxService {
    GearBox getById(Integer id);

    void save(GearBox gearBox);

    void delete(Integer id);

    List<GearBox> getAll();
}
