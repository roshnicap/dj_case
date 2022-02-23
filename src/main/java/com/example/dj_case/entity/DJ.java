package com.example.dj_case.entity;

import javax.persistence.*;

@Table(name = "dj")
@Entity
public class DJ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dj_id")
    private Long id;

    @Column(name = "dj_name")
    public String name;

    @Column(name = "dj_age")
    public Integer age;

    @Column(name = "dj_style")
    public String style;

    public DJ() {
    }

    public DJ(String name, Integer age, String style) {
        this.name = name;
        this.age = age;
        this.style = style;
    }

    @Override
    public String toString() {
        return "DJ{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", style='" + style + '\'' +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}



