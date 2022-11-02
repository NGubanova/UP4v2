package com.example.up1v2.Repository;

import com.example.up1v2.Models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
