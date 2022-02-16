package com.example.dj_case.entity;

import javax.persistence.*;

public class DJ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="dj_id")
    public Integer id;

    @Column(name="dj_name")
    public String name;

    @Column(name="dj_age")
    public Integer age;

    @Column(name="dj_style")
    public String style;

    public DJ(Integer id, String name, Integer age, String style) {
        this.name = name;
        this.age = age;
        this.style = style;
    }
}
