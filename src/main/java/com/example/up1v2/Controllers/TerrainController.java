package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Terrain;
import com.example.up1v2.Repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TerrainController {

    @Autowired
    TerrainRepository terrainRepository;
    @GetMapping("/terrain")
    public String TerrainMain(Model model){
        Iterable<Terrain> listTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", listTerrain);
        return "terrain/index";
    }

    @GetMapping("terrain/add")
    public String TerrainAddView(Model model){
        return "terrain/add";
    }

    @PostMapping("terrain/add")
    public String TerrainAdd(@RequestParam String name,
                         @RequestParam String animal,
                         @RequestParam String description,
                         @RequestParam String responsible,
                         @RequestParam Integer place, Model model){
        Terrain terrain = new Terrain(name,animal, description, responsible, place);
        terrainRepository.save(terrain);
        return "redirect:/terrain";
    }

    @GetMapping("/terrain/filter")
    public String TerrainFilter(@RequestParam String searchName,
                            Model model){
        List<Terrain> terrain = terrainRepository.findByNameContaining(searchName);
        model.addAttribute("listTerrain", terrain);
        return "terrain/index";
    }
}
