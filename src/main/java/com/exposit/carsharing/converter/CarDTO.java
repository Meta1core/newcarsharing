package com.exposit.carsharing.converter;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class CarDTO {
    public Integer id;
    public Integer modelID;
    public Integer markID;
    public Integer gearboxID;
    public Integer carcaseID;
    public Integer motorcontrollerID;
    public Integer engineID;
    public Integer fuelID;
    public Integer year;
    public String carnumber;
    public Integer mileage;
    public Integer numberplace;
    public String location;
    public Integer consumption;
    public String status;
    public String items;
    public String insurance;
    public Integer price;
    public String text;
    public Date calendar;
    public String gif;
}