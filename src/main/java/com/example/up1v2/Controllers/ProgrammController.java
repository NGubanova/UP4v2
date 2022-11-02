package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Programm;
import com.example.up1v2.Models.Terrain;
import com.example.up1v2.Repository.ProgrammRepository;
import com.example.up1v2.Repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/programm")
public class ProgrammController {

    @Autowired
    ProgrammRepository programmRepository;
    @Autowired
    TerrainRepository terrainRepository;
    @GetMapping("")
    public String programmMain(Model model){
        Iterable<Programm> listprogramm = programmRepository.findAll();
        model.addAttribute("listProgramm", listprogramm);
        return "programm/index";
    }

    @GetMapping("/add")
    public String programmAddView(Programm programm, Model model){
        Iterable<Terrain> ListTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", ListTerrain);

        return "programm/add";
    }

    @PostMapping("/add")
    public String programmAdd(@Valid Programm programm,
                              BindingResult result,
                              Model model,
                              @RequestParam(name = "terrain") String[] terrain){
        if(result.hasErrors())
            return "programm/add";
        Iterable<Terrain> terrain_list = terrainRepository.findAll();
        for (Terrain terrainn: terrain_list){
            if(terrainn.getProgramm() == null){
                programm.getTerrain().add(terrainn);
            }
        }
        programmRepository.save(programm);

        return "redirect:/programm";
    }
    @GetMapping("/details/{id}")
    public String programmDetails(Model model,
                             @PathVariable long id) {
        Programm programm = programmRepository.findById(id).orElseThrow();
        model.addAttribute("programm", programm);
        Iterable<Terrain> ListTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", ListTerrain);
        return ("/programm/details");
    }

    @GetMapping("/edit/{id}")
    public String programmEdit(Model model,
                          @PathVariable long id) {
        Programm programm = programmRepository.findById(id).orElseThrow();
        model.addAttribute("programm", programm);
        Iterable<Terrain> ListTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", ListTerrain);
        return("/programm/edit");
    }

    @PostMapping("/edit/{id}")
    public String programmEdit(@Valid Programm programm,
                          BindingResult result) {
        if (result.hasErrors())
            return("/programm/edit");

        programmRepository.save(programm);

        return("redirect:/programm/details/" + programm.getId());
    }

    @GetMapping("/delete/{id}")
    public String programmDelete(@PathVariable long id) {
        programmRepository.deleteById(id);
        return("redirect:/programm");
    }

    @GetMapping("/filter")
    public String programmFilter(@RequestParam String searchName,
                            Model model){
        List<Programm> programm = programmRepository.findByNameContaining(searchName);
        model.addAttribute("listProgram", programm);
        return "programm/index";
    }
}
