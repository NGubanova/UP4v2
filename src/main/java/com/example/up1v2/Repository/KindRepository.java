package com.example.up1v2.Repository;

import com.example.up1v2.Models.Kind;
import org.springframework.data.repository.CrudRepository;

public interface KindRepository extends CrudRepository<Kind, Long> {
    Kind findByName(String name);
}
