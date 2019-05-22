package com.exposit.carsharing.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "тип_коробкип")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GearBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_GearBox;

    @Column(name = "Тип_КоробкиП")
    private String gearbox;

    @JsonBackReference
    @OneToMany(mappedBy = "gearbox", targetEntity = Car.class, fetch = FetchType.EAGER)
    private Collection gearboxes;

}