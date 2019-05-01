package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_двигателя")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_Engine;
    @Column(name = "Тип_Двигателя")
    private String engine;

    @JsonBackReference
    @OneToMany(mappedBy="engine",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection engines;

}