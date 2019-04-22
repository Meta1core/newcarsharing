package com.exposit.carsharing.model.containers;

import com.exposit.carsharing.model.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_привода")
@Data
public class MotorController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_MotorController;

    @Column(name = "Тип_Привода")
    private String MotorController;

    @OneToMany(mappedBy="motorController",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection motors;

}