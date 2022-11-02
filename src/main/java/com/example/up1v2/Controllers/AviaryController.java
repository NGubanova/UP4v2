package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Aviary;
import com.example.up1v2.Repository.AviaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/aviary")
public class AviaryController {
    @Autowired
    AviaryRepository aviaryRepository;
    @GetMapping("")
    public String aviaryMain(Aviary aviary,
                              Model model){
        Iterable<Aviary> ListAviary = aviaryRepository.findAll();
        model.addAttribute("listAviary", ListAviary);
        return "aviary";
    }

    @PostMapping("")
    public String aviaryAdd(@Valid Aviary aviary,
                             BindingResult result){
        if(result.hasErrors())
            return ("aviary");

        aviaryRepository.save(aviary);
        return "redirect:/aviary";
    }

    @GetMapping("/delete/{id}")
    public String aviaryDelete(@PathVariable long id) {
        aviaryRepository.deleteById(id);
        return("redirect:/aviary");
    }
}
