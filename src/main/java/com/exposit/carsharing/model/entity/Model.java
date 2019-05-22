package com.exposit.carsharing.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "модель")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Код")
    private Integer ID_Model;

    @Column(name = "Модель")
    private String Model;

    @JsonBackReference
    @OneToMany(mappedBy = "model", targetEntity = Car.class, fetch = FetchType.EAGER)
    private Collection models;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Марка", referencedColumnName = "Код", nullable = false)
    private Mark markbackend;

    public Model() {
    }

    public Model(Integer ID_Model, String model, Set models, Mark mark) {
        this.ID_Model = ID_Model;
        this.Model = model;
        this.models = models;
        this.markbackend = mark;
    }
}
