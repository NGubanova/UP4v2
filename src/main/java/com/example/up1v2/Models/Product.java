package com.example.up1v2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Заполните название продукта")
    @Size(min=1, max=100)
    private String name;

    @ManyToMany
    @JoinTable (name="product_food",
            joinColumns=@JoinColumn (name="product_id"),
            inverseJoinColumns=@JoinColumn(name="food_id"))
    private List<Food> foods;

    public Product() {
    }

    public Product(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
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

    public List<Food> getFood() {
        return foods;
    }

    public void setFood(List<Food> foods) {
        this.foods = foods;
    }
}
