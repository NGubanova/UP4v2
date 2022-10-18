package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Zoo;
import com.example.up1v2.Repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ZooController {
    @Autowired
    ZooRepository zooRepository;
    @GetMapping("/zoo")
    public String zooMain(Model model){
        Iterable<Zoo> listZoo = zooRepository.findAll();
        model.addAttribute("listAnimal", listZoo);
        return "zoo/index";
    }

    @GetMapping("zoo/add")
    public String zooAddView(Model model){
        return "zoo/add";
    }

    @PostMapping("zoo/add")
    public String zooAdd(@RequestParam String name,
                         @RequestParam Integer age,
                         @RequestParam String description,
                         @RequestParam Integer weight,
                         @RequestParam Integer height, Model model){
        Zoo zoo = new Zoo(name, age, description, weight, height);
        zooRepository.save(zoo);
        return "redirect:/zoo";
    }

    @GetMapping("/zoo/filter")
    public String zooFilter(@RequestParam String searchName,
                            Model model){
        List<Zoo> zoo = zooRepository.findByNameContaining(searchName);
        model.addAttribute("listAnimal", zoo);
        return "zoo/index";
    }
}
