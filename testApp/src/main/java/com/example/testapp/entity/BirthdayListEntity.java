package com.example.testapp.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class BirthdayListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToMany(mappedBy = "list")
    private List<PersonEntity> persons;

    public BirthdayListEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
