package com.example.dj_case.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="set_id")
    public Integer id;

    @Column(name="set_name")
    public String name;

    @Column(name="set_day")
    public Date day;

    @Column(name="set_stage")
    public String stage;

    @Column(name="set_begintime")
    public LocalTime beginTime;

    @Column(name="set_endtime")
    public LocalTime endTime;

    public Set(Integer id, String name, Date day, String stage, LocalTime beginTime, LocalTime endTime) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.stage = stage;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
}
