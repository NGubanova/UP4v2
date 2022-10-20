package com.example.up1v2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Заполните поле")
    @Size (min = 1, max = 30, message = "Поле должно содержать от 1 до 30 символов")
    private String name;
    @NotNull(message = "Заполните поле")
    @Max(value = 150, message ="Возраст не может быть больше 150 лет" )
    @Min(value = 14, message ="Младше 14 лет не может быть сотрудник" )
    private Integer age;
    @NotBlank(message = "Заполните поле")
    @Size (min = 1, max = 100, message = "Поле должно содержать от 1 до 100 символов")
    private String post;
    @NotBlank(message = "Заполните поле")
    @Size (min = 1, max = 50, message = "Поле должно содержать от 1 до 50 символов")
    private String animal;
    @NotBlank(message = "Заполните поле")
    @Size (min = 1, max = 100, message = "Поле должно содержать от 1 до 100 символов")
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }
}
