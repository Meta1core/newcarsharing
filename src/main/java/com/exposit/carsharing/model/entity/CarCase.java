package com.exposit.carsharing.model.entity;

import com.exposit.carsharing.model.entity.Car;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_кузова")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer Id_CarCase;
    @Column(name = "Тип_Кузова")
    private String carcase;

    @JsonBackReference
    @OneToMany(mappedBy="carcase",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection carcases;

}