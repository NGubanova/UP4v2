package com.example.up1v2.Repository;

import com.example.up1v2.Models.Terrain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TerrainRepository extends CrudRepository<Terrain, Long> {


    public List<Terrain> findByNameContaining(String name);
}
