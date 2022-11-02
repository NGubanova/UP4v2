package com.example.up1v2.Models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Заполните название должности")
    @Size(min=6, max=100)
    private String name;
    @NotNull(message = "Введите размер оклада")
    private Integer salary;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Collection<Employee> employees;

    public Post(String name, Integer salary, Collection<Employee> employees) {
        this.name = name;
        this.salary = salary;
        this.employees = employees;
    }

    public Post() {

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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
