package com.exposit.carsharing.model.entity.containers;


import com.exposit.carsharing.model.entity.Car;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="тип_коробкип")
@Data
public class GearBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_GearBox;

    @Column(name = "Тип_КоробкиП")
    private String gearbox;

    @OneToMany(mappedBy="gearbox",targetEntity= Car.class, fetch=FetchType.EAGER)
    private Collection gearboxes;

}