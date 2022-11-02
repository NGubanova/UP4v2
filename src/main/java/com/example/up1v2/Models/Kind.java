package com.example.up1v2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Введите название вида животного")
    @Size(min=2, max=100)
    private String name;
    @OneToMany(mappedBy = "kind", fetch = FetchType.EAGER)
    private Collection<Zoo> zoo;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Clas clas;

    public Kind(String name, Clas clas) {
        this.name = name;
        this.clas = clas;
    }

    public Kind() {
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

    public Collection<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(Collection<Zoo> zoo) {
        this.zoo = zoo;
    }

    public Clas getClas() {
        return clas;
    }

    public void setClas(Clas clas) {
        this.clas = clas;
    }
}
