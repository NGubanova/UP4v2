package com.example.up1v2.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bookers;
    private Integer phone;
    private String dateTime;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Programm programm;

    public Excursion(String bookers, Integer phone, String dateTime, Programm programm) {
        this.bookers = bookers;
        this.phone = phone;
        this.dateTime = dateTime;
        this.programm = programm;
    }

    public Excursion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookers() {
        return bookers;
    }

    public void setBookers(String bookers) {
        this.bookers = bookers;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Programm getProgramm() {
        return programm;
    }

    public void setProgramm(Programm programm) {
        this.programm = programm;
    }
}
