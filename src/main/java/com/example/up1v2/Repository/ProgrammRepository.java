package com.example.up1v2.Repository;

import com.example.up1v2.Models.Programm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProgrammRepository extends CrudRepository<Programm, Long> {
    List<Programm> findByNameContaining(String name);
    Programm findByName(String name);
}
