package com.example.up1v2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Заполните название рациона")
    @Size(min=2, max=100)
    private String name;
    @NotBlank(message = "Заполните описание")
    @Size(min=1, max=300)
    private String description;

    @ManyToMany
    @JoinTable(name="product_food",
            joinColumns=@JoinColumn(name="food_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<Product> products;

    @OneToMany(mappedBy = "food", fetch = FetchType.EAGER)
    private Collection<Zoo> zoo;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Collection<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(Collection<Zoo> zoo) {
        this.zoo = zoo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
