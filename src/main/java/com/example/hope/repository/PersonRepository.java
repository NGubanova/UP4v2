package com.example.hope.repository;

import com.example.hope.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByNameContaining(String name);
}
