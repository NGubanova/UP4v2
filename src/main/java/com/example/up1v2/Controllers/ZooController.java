package com.example.up1v2.Controllers;

import com.example.up1v2.Models.*;
import com.example.up1v2.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/zoo")
@PreAuthorize("hasAuthority('ADMIN')")
public class ZooController {
    @Autowired
    ZooRepository zooRepository;
    @Autowired
    KindRepository kindRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    AviaryRepository aviaryRepository;
    @Autowired
    TerrainRepository terrainRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("")
    public String zooMain(Model model){
        Iterable<Zoo> listZoo = zooRepository.findAll();
        model.addAttribute("listAnimal", listZoo);
        return "zoo/index";
    }

    @GetMapping("/add")
    public String zooAddView(Zoo zoo, Model model){
        Iterable<Kind> ListKind = kindRepository.findAll();
        model.addAttribute("listKind", ListKind);

        Iterable<Food> ListFood = foodRepository.findAll();
        model.addAttribute("listFood", ListFood);

        Iterable<Aviary> ListAviary = aviaryRepository.findAll();
        model.addAttribute("listAviary", ListAviary);

        Iterable<Terrain> ListTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", ListTerrain);

        Iterable<Employee> ListEmployee = employeeRepository.findAll();
        model.addAttribute("listEmployee", ListEmployee);

        return "zoo/add";
    }

    @PostMapping("/add")
    public String zooAdd(@Valid Zoo zoo, BindingResult result,
                         @RequestParam String name,
                         @RequestParam Integer age,
                         @RequestParam String description,
                         @RequestParam Integer weight,
                         @RequestParam Integer height,
                         @RequestParam String listKind,
                         @RequestParam String listFood,
                         @RequestParam String listAviary,
                         @RequestParam String listTerrain,
                         @RequestParam String listEmployee,
                         Model model){

        Iterable<Kind> ListKind = kindRepository.findAll();
        model.addAttribute("listKind", ListKind);

        Iterable<Food> ListFood = foodRepository.findAll();
        model.addAttribute("listFood", ListFood);

        Iterable<Aviary> ListAviary = aviaryRepository.findAll();
        model.addAttribute("listAviary", ListAviary);

        Iterable<Terrain> ListTerrain = terrainRepository.findAll();
        model.addAttribute("listTerrain", ListTerrain);

        Iterable<Employee> ListEmployee = employeeRepository.findAll();
        model.addAttribute("listEmployee", ListEmployee);
        if(result.hasErrors())
            return "zoo/add";
        else {
            Kind kind = kindRepository.findByName(listKind);
            Food food = foodRepository.findByName(listFood);
            Aviary aviary = aviaryRepository.findByType(listAviary);
            Terrain terrain = terrainRepository.findByName(listTerrain);
            Employee employee = employeeRepository.findByUsername(listEmployee);
            zoo = new Zoo(name, age, description, weight, height, kind, aviary, food, employee, terrain);

            zooRepository.save(zoo);
        }
        return "redirect:/zoo";
    }
    @GetMapping("/details/{id}")
    public String zooDetails(Model model,
                                  @PathVariable long id) {
        Zoo zoo = zooRepository.findById(id).orElseThrow();
        model.addAttribute("animal", zoo);
        return ("/zoo/details");
    }

    @GetMapping("/edit/{id}")
    public String zooEdit(Model model,
                               @PathVariable long id) {
        Zoo zoo = zooRepository.findById(id).orElseThrow();
        model.addAttribute("zoo", zoo);
        return("/zoo/edit");
    }

    @PostMapping("/edit/{id}")
    public String zooEdit(@Valid Zoo zoo,
                          BindingResult result) {
        if (result.hasErrors())
            return("/zoo/edit");

        zooRepository.save(zoo);

        return("redirect:/zoo/details/" + zoo.getId());
    }

    @GetMapping("/delete/{id}")
    public String zooDelete(@PathVariable long id) {
        zooRepository.deleteById(id);
        return("redirect:/zoo");
    }

    @GetMapping("/filter")
    public String zooFilter(@RequestParam String searchName,
                            Model model){
        List<Zoo> zoo = zooRepository.findByNameContaining(searchName);
        model.addAttribute("listAnimal", zoo);
        return "zoo/index";
    }
}
