package com.exposit.carsharing.model.entity.containers;

import com.exposit.carsharing.model.entity.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_двигателя")
@Data
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_Engine;
    @Column(name = "Тип_Двигателя")
    private String engine;

    @OneToMany(mappedBy="engine",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection engines;

}