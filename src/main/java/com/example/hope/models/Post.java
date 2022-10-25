package com.example.hope.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Collection<Person> users;

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

    public Collection<Person> getUsers() {
        return users;
    }

    public void setUsers(Collection<Person> users) {
        this.users = users;
    }
}
