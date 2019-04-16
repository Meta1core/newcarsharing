package com.exposit.carsharing.model.conteiners;

import com.exposit.carsharing.model.Car;
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