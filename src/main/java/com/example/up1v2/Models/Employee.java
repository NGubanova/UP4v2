package com.example.up1v2.Models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле не должно быть пустым!")
    @Size(min = 1, max = 150, message = "Поле должно содержать от 1 до 150 символов")
    private String name;

    @NotBlank(message = "Поле не должно быть пустым!")
    @Size(min = 5, max = 30, message = "Поле должно содержать от 5 до 30 символов")
    private String username;
    @Pattern(regexp = "^(?=.*[0-9])" +
        "(?=.*[a-z])" +
        "(?=.*[A-Z])" +
        "(?=.*[!@#$%^&+=])" +
        "(?=\\S+$)" +
        ".{6,}", message = "Пароль должен быть не меньше 6 символов,"+ "\n" +
            "иметь числа и латинкие строчные и заглавные буквы," + "\n" +
            "а также специальные символы ")
    private String password;

    private Boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Post post;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Zoo> zoo;

    public Employee() {
    }

    public Employee(String name, String username, Post post) {
        this.name = name;
        this.username = username;
//        this.active = active;
//        this.roles = roles;
        this.post = post;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Collection<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(Collection<Zoo> zoo) {
        this.zoo = zoo;
    }
}