package com.exposit.carsharing.model.containers;

import com.exposit.carsharing.model.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="модель")
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Код")
    private Integer ID_Model;

    @Column(name ="Модель")
    private String Model;


    @OneToMany(mappedBy="model",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection models;



}
