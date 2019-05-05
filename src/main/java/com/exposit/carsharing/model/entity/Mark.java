package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.Car;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name ="марка")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Код")
    private Integer ID_Mark;

    @Column(name ="Марка")
    private String mark;

    @JsonBackReference
    @OneToMany(mappedBy="mark",targetEntity= Car.class, fetch=FetchType.LAZY)
    private Set<Car> marks = new HashSet<Car>();



}
