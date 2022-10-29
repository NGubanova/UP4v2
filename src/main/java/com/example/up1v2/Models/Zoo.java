package com.example.up1v2.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Заполните поле")
    @Size(min = 1, max = 30, message = "Поле должно содержать от 1 до 30 символов")
    private String name;
    @NotNull(message = "Заполните поле")
    @Max(value = 250, message ="Возраст не может быть больше 250 лет" )
    @Min(value = 0, message ="Младше 0 лет не может быть животное" )
    private Integer age;
    @NotBlank(message = "Заполните поле")
    @Size (min = 1, max = 250, message = "Поле должно содержать от 1 до 250 символов")
    private String description;
    @NotNull(message = "Заполните поле")
    @Max(value = 10000, message ="Вес не может быть более 10 000 кг" )
    @Min(value = 0, message ="Вес не может быть отрицательным" )
    private Integer weight;
    @NotNull(message = "Заполните поле")
    @Max(value = 300, message ="Рост не может быть больше 300 м" )
    @Min(value = 0, message ="Отрицательного значения не может быть" )
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
