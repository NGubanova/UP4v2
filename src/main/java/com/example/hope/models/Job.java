package com.example.hope.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    @ManyToMany
    @JoinTable(name = "job_user",
    joinColumns = @JoinColumn(name = "job_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Person> peoples;

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

    public List<Person> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<Person> peoples) {
        this.peoples = peoples;
    }
}
