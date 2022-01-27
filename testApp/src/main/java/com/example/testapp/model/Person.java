package com.example.testapp.model;

import com.example.testapp.entity.PersonEntity;

import java.sql.Date;

public class Person {

    private String name;
    private Date birthDay;


    public static Person toModel(PersonEntity entity) {
        Person model = new Person();
        model.setName(entity.getName());
        model.setBirthDay(entity.getBirthDay());
        return model;
    }

    Person(){

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
}
