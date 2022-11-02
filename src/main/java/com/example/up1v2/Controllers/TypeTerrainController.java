package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Terrain;
import com.example.up1v2.Models.Type;
import com.example.up1v2.Repository.TerrainRepository;
import com.example.up1v2.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class TypeTerrainController {

    @Autowired
    TypeRepository typeRepository;
    @Autowired
    TerrainRepository terrainRepository;
    @GetMapping("/type")
    public String typeMain(Type type,
                           Model model){
        Iterable<Type> ListType = typeRepository.findAll();
        model.addAttribute("listType", ListType);
        return "type";
    }

    @PostMapping("/type")
    public String typeAdd(@Valid Type type,
                            BindingResult result){
        if(result.hasErrors())
            return ("type");

        typeRepository.save(type);
        return "redirect:/type";
    }

    @GetMapping("/type/delete/{id}")
    public String typeDelete(@PathVariable long id) {
        typeRepository.deleteById(id);
        return("redirect:/type");
    }

    @GetMapping("/terrain")
    public String terrainMain(Terrain terrain,
                           Model model){
        Iterable<Terrain> ListTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", ListTerrain);
        Iterable<Type> type = typeRepository.findAll();
        model.addAttribute("typeList", type);
        return "terrain";
    }

    @PostMapping("/terrain")
    public String terrainAdd(@Valid Terrain terrain,
                             BindingResult result,
                          @RequestParam String name,
                          @RequestParam String typeName,
                          @RequestParam String description,
                          @RequestParam Integer area){
        if(result.hasErrors()){
            return ("terrain");
        };

        Type type = typeRepository.findByName(typeName);
        terrain = new Terrain(name, description, area, type);
        terrainRepository.save(terrain);
        return "redirect:/terrain";
    }

    @GetMapping("terrain/delete/{id}")
    public String terrainDelete(@PathVariable long id) {
        terrainRepository.deleteById(id);
        return("redirect:/terrain");
    }
}
