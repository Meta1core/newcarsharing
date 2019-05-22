package com.exposit.carsharing.model.payload;

import lombok.Data;

@Data
public class ModelEditDTO {
    private Integer id_Model;
    private String Model;
    private Integer markID;
}