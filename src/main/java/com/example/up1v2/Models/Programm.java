package com.example.up1v2.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Programm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer billet;
    private Integer price;

    @ManyToMany
    @JoinTable (name="programm_terrain",
            joinColumns=@JoinColumn (name="programm_id"),
            inverseJoinColumns=@JoinColumn(name="terrain_id"))
    private List<Terrain> terrain;

    @OneToMany(mappedBy = "programm", fetch = FetchType.EAGER)
    private Collection<Excursion> excursions;

    public Programm() {
    }

    public Programm(String name, String description, Integer billet, Integer price, List<Terrain> terrain) {
        this.name = name;
        this.description = description;
        this.billet = billet;
        this.price = price;
        this.terrain = terrain;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBillet() {
        return billet;
    }

    public void setBillet(Integer billet) {
        this.billet = billet;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Terrain> getTerrain() {
        return terrain;
    }

    public void setTerrain(List<Terrain> terrain) {
        this.terrain = terrain;
    }

    public Collection<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Collection<Excursion> excursions) {
        this.excursions = excursions;
    }
}
