package com.exposit.carsharing.model.conteiners;

import com.exposit.carsharing.model.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_кузова")
@Data
public class CarCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer Id_CarCase;
    @Column(name = "Тип_Кузова")
    private String carcase;

    @OneToMany(mappedBy="carcase",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection carcases;

}