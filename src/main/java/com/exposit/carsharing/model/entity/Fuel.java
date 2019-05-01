package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="вид_топлива")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_Fuel;

    @Column(name = "Топливо")
    private String Fuel;

    @JsonBackReference
    @OneToMany(mappedBy = "fuel")
    private List<Car> fuels;

}