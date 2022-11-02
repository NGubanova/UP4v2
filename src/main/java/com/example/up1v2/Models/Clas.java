package com.example.up1v2.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Clas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Введите название класса животного")
    @Size(min=2, max=100)
    private String name;
    @OneToMany(mappedBy = "clas", fetch = FetchType.EAGER)
    private Collection<Kind> kind;

    public Clas() {
    }

    public Clas(String name, Collection<Kind> kind) {
        this.name = name;
        this.kind = kind;
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

    public Collection<Kind> getKind() {
        return kind;
    }

    public void setKind(Collection<Kind> kind) {
        this.kind = kind;
    }
}
