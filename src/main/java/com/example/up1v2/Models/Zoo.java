package com.example.up1v2.Models;

import javax.persistence.*;
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

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Kind kind;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Aviary aviary;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Food food;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Employee user;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Terrain terrain;

    public Zoo(){}

    public Long getId() {
        return id;
    }

    public Zoo(String name, Integer age, String description, Integer weight, Integer height, Kind kind, Aviary aviary, Food food, Employee user, Terrain terrain) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.kind = kind;
        this.aviary = aviary;
        this.food = food;
        this.user = user;
        this.terrain = terrain;
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

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Aviary getAviary() {
        return aviary;
    }

    public void setAviary(Aviary aviary) {
        this.aviary = aviary;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
