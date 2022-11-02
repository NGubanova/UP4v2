package com.example.up1v2.Repository;

import com.example.up1v2.Models.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Long> {
    Food findByName(String name);
//    public List<String> findByAllProducts(String);
}
