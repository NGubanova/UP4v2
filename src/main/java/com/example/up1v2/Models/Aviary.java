package com.example.up1v2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Aviary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Заполните тип вольера")
    @Size(min=2, max=100)
    private String type;

    @OneToMany(mappedBy = "aviary", fetch = FetchType.EAGER)
    private Collection<Zoo> zoo;

    public Aviary(String type, Collection<Zoo> zoo) {
        this.type = type;
        this.zoo = zoo;
    }

    public Aviary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(Collection<Zoo> zoo) {
        this.zoo = zoo;
    }
}
