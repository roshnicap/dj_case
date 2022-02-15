package com.example.dj_case.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Set_id")
    private int id;

    private String name;
    private Date day;
    private String stage;
    private LocalTime beginTime;
    private LocalTime endTime;
}
