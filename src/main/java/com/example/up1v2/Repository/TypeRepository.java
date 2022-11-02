package com.example.up1v2.Repository;

import com.example.up1v2.Models.Type;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {
    Type findByName(String name);
}
