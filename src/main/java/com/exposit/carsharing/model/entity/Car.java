package com.exposit.carsharing.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.SELECT;

@Entity
@Table(name = "car")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Марка", referencedColumnName = "Код", nullable = false)
    private Mark mark;

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


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Тип_КоробкиП", referencedColumnName = "Код", nullable = false)
    private GearBox gearbox;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Тип_Кузова", referencedColumnName = "Код", nullable = false)
    private CarCase carcase;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Привод", referencedColumnName = "Код", nullable = false)
    private MotorController motorController;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ДВС", referencedColumnName = "Код", nullable = false)
    private Engine engine;


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

    @Fetch(value = SELECT)
    @ManyToMany(mappedBy="cars")
    private Set<User> user = new HashSet();

}
