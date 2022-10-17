package com.example.up1v2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String description;
    private Integer weight;
    private Integer height;

    public Zoo(String name, Integer age,
               String description, Integer weight, Integer height){
        this.name = name;
        this.age = age;
        this.description = description;
        this.weight = weight;
        this.height = height;
    }

    public Zoo(){}

    public Long getId() { return id;}
    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {return age;}
    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getWeight() {return weight;}
    public Integer getHeight() {return height;}
}
