package com.exposit.carsharing.service;

import com.exposit.carsharing.model.entity.Mark;

import java.util.List;

public interface MarkService {
    Mark getById(Integer id);

    void save(Mark mark);

    void delete(Integer id);

    List<Mark> getAll();
}
