package com.example.dj_case.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
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

    public Set() {
        super();
    }

    public Set(String name, Date day, String stage, LocalTime beginTime, LocalTime endTime) {
        super();
        this.name = name;
        this.day = day;
        this.stage = stage;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
