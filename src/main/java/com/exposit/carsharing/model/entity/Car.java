package com.exposit.carsharing.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Марка", referencedColumnName = "Код", nullable = false)
    private Mark mark;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Модель", referencedColumnName = "Код", nullable = false)
    private Model model;


    @Column(name = "Год_Выпуска")
    private Integer year;


    @Column(name = "Гос_Номер")
    private String carNumber;


    @Column(name = "Пробег")
    private Integer mileage;


    @Column(name = "Колво_Мест")
    private Integer numberPlace;


    @Column(name = "Местанахождение")
    private String location;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Тип_КоробкиП", referencedColumnName = "Код", nullable = false)
    private GearBox gearbox;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Тип_Кузова", referencedColumnName = "Код", nullable = false)
    private CarCase carcase;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Привод", referencedColumnName = "Код", nullable = false)
    private MotorController motorController;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ДВС", referencedColumnName = "Код", nullable = false)
    private Engine engine;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Вид_Топлива")
    private Fuel fuel;


    @Column(name = "Расход")
    private Integer consumption;


    @Column(name = "Состояние_Машины")
    private String status;


    @Column(name = "Доп_Аксессуары")
    private String items;


    @Column(name = "Страховка")
    private String insurance;


    @Column(name = "Цена")
    private Integer price;


    @Column(name = "Текст")
    private String text;


    @Column(name = "Календарь_доступности")
    @Temporal(TemporalType.DATE)
    private Date calendar;

    @Column(name = "giphy")
    private String giphy;
}
