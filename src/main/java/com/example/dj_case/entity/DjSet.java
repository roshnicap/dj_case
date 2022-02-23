package com.example.dj_case.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "set")
@Entity
public class DjSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="set_id")
    private Long id;

    @Column(name="set_name")
    public String name;

    @Column(name="set_day")
    public LocalDate day;

    @Column(name="set_stage")
    public String stage;

    @Column(name="set_begintime")
    public LocalTime beginTime;

    @Column(name="set_endtime")
    public LocalTime endTime;

    @ManyToOne()
    @JoinColumn(name = "fk_dj_id")
    public DJ dj;

    public DjSet() {
    }

    public DjSet(String name, LocalDate day, String stage, LocalTime beginTime, LocalTime endTime, DJ dj) {
        this.name = name;
        this.day = day;
        this.stage = stage;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.dj = dj;
    }

    @Override
    public String toString() {
        return "Set{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", stage='" + stage + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
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

    public DJ getDj() {
        return dj;
    }

    public void setDj(DJ dj) {
        this.dj = dj;
    }
}
