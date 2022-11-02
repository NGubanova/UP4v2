package com.example.up1v2.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
    private Collection<Terrain> terrains;

    public Type() {
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

    public Collection<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(Collection<Terrain> terrains) {
        this.terrains = terrains;
    }
}
