package com.example.up1v2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Заполните название территории")
    @Size(min=6, max=100)
    private String name;

    @NotBlank(message = "Заполните описание")
    @Size(min=6, max=100)
    private String description;

    @NotNull(message = "Введите размер территории")
    private Integer area;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Type type;

    @OneToMany(mappedBy = "terrain", fetch = FetchType.EAGER)
    private Collection<Zoo> zoo;

    @ManyToMany
    @JoinTable (name="programm_terrain",
            joinColumns=@JoinColumn (name="terrain_id"),
            inverseJoinColumns=@JoinColumn(name="programm_id"))
    private List<Programm> programm;

    public Terrain() {
    }

    public Terrain(String name, String description, Integer area, Type type) {
        this.name = name;
        this.description = description;
        this.area = area;
        this.type = type;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(Collection<Zoo> zoo) {
        this.zoo = zoo;
    }

    public List<Programm> getProgramm() {
        return programm;
    }

    public void setProgramm(List<Programm> programm) {
        this.programm = programm;
    }
}
