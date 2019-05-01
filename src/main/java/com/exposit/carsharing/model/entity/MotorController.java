package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_привода")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MotorController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_MotorController;

    @Column(name = "Тип_Привода")
    private String MotorController;

    @JsonBackReference
    @OneToMany(mappedBy="motorController",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection motors;

}