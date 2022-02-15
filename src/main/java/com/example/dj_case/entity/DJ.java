package com.example.dj_case.entity;

import javax.persistence.*;

@Entity
public class DJ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="DJ_id")
    private int id;

    @Column(name="DJ_name")
    private String name;

    @Column(name="DJ_age")
    private int age;

    @Column(name="DJ_style")
    private String style;
}
