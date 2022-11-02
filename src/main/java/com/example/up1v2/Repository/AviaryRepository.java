package com.example.up1v2.Repository;

import com.example.up1v2.Models.Aviary;
import org.springframework.data.repository.CrudRepository;

public interface AviaryRepository extends CrudRepository<Aviary, Long> {
    Aviary findByType(String type);
}
