package com.example.up1v2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String post;
    private String animal;
    private String timetable;

    public Employee(String name, Integer age,
                    String post, String animal, String timetable){
        this.name = name;
        this.age = age;
        this.post = post;
        this.animal = animal;
        this.timetable = timetable;
    }
    public Employee(){}

    public Long getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {return age;}
    public String getPost() {return post;}
    public String getAnimal() {return animal;}
    public String getTimetable() {return timetable;}
}
