package com.example.testapp.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthDay;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private BirthdayListEntity list;
    public PersonEntity() {

    }

    public PersonEntity(Long id, String name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public BirthdayListEntity getList() {
        return list;
    }

    public void setList(BirthdayListEntity list) {
        this.list = list;
    }
}
