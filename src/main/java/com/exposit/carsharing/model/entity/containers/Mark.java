package com.exposit.carsharing.model.entity.containers;

import com.exposit.carsharing.model.entity.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="марка")
@Data
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Код")
    private Integer ID_Mark;

    @Column(name ="Название")
    private String mark;

    @OneToMany(mappedBy="mark",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection marks;


}
