package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="вид_топлива")
@Data
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_Fuel;

    @Column(name = "Топливо")
    private String Fuel;

    @OneToMany(mappedBy = "fuel")
    private List<Car> fuels;

}