package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Excursion;
import com.example.up1v2.Models.Programm;
import com.example.up1v2.Repository.ExcursionRepository;
import com.example.up1v2.Repository.ProgrammRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/excursion")
@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
public class ExcursionController {
    @Autowired
    ExcursionRepository excursionRepository;
    @Autowired
    ProgrammRepository programmRepository;
    @GetMapping("")
    public String excursionMain(Model model){
        Iterable<Excursion> listExcursion =excursionRepository.findAll();
        model.addAttribute("listExcursion", listExcursion);
        return "excursion/index";
    }

    @GetMapping("/add")
    public String excursionAddView(Excursion excursion, Model model){
        Iterable<Programm> programm = programmRepository.findAll();
        model.addAttribute("Programm", programm);
        return "excursion/add";
    }

    @PostMapping("/add")
    public String excursionAdd(@Valid Excursion excursion,
                              @RequestParam String bookers,
                              @RequestParam Integer phone,
                              @RequestParam String dateTime,
                              @RequestParam String listProgramm,
                              BindingResult result){
        if(result.hasErrors())
            return ("excursion/add");
        Programm programm = programmRepository.findByName(listProgramm);
        Iterable<Programm> programms_list = programmRepository.findAll();

        excursion = new Excursion(bookers, phone, dateTime, programm);

        excursionRepository.save(excursion);
        return "redirect:/excursion";
    }

    @GetMapping("/details/{id}")
    public String excursionDetails(Model model,
                                  @PathVariable long id) {
        Excursion excursion=excursionRepository.findById(id).orElseThrow();
        model.addAttribute("excursion",excursion);
        return ("excursion/details");
    }

    @GetMapping("/edit/{id}")
    public String excursionEdit(Model model,
                               @PathVariable long id) {
        Excursion excursion=excursionRepository.findById(id).orElseThrow();
        model.addAttribute("excursion",excursion);

        return("excursion/edit");
    }

    @PostMapping("/edit/{id}")
    public String excursionEdit(@Valid Excursion excursion,
                                BindingResult result) {


        excursionRepository.save(excursion);
        return("redirect:excursion/details/" +excursion.getId());
    }

    @GetMapping("/delete/{id}")
    public String excursionDelete(@PathVariable long id) {
        excursionRepository.findById(id).orElseThrow();
        return("redirect:excursion");
    }
}
