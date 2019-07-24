package com.exposit.carsharing.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "rent_requests")
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    @Temporal(TemporalType.DATE)
    private Date firstdate;

    @Temporal(TemporalType.DATE)
    private Date seconddate;

    private Integer price;
}
