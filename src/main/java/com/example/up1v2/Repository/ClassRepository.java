package com.example.up1v2.Repository;

import com.example.up1v2.Models.Clas;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Clas, Long> {
    Clas findByName(String name);
}
