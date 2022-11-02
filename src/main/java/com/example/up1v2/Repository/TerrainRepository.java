package com.example.up1v2.Repository;

import com.example.up1v2.Models.Terrain;
import org.springframework.data.repository.CrudRepository;

public interface TerrainRepository extends CrudRepository<Terrain, Long> {
    Terrain findByName(String name);
}
