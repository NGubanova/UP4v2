package com.example.up1v2.Repository;

import com.example.up1v2.Models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZooRepository extends CrudRepository<Zoo, Long> {


    public List<Zoo> findByNameContaining(String name);
}
