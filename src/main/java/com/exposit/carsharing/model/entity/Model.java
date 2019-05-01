package com.exposit.carsharing.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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
    private Mark mark;

}
