package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Clas;
import com.example.up1v2.Models.Kind;
import com.example.up1v2.Repository.ClassRepository;
import com.example.up1v2.Repository.KindRepository;
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
public class ClasKindController {

    @Autowired
    ClassRepository classRepository;
    @Autowired
    KindRepository kindRepository;

    @GetMapping("/clas")
    public String clasMain(Clas clas,
                              Model model){
        Iterable<Clas> ListClas = classRepository.findAll();
        model.addAttribute("listClas", ListClas);
        return "clas";
    }

    @PostMapping("/clas")
    public String clasAdd(@Valid Clas clas,
                             BindingResult result){
        if(result.hasErrors())
            return ("clas");

        classRepository.save(clas);
        return "redirect:/clas";
    }

    @GetMapping("clas/delete/{id}")
    public String clasDelete(@PathVariable long id) {
        classRepository.deleteById(id);
        return("redirect:/clas");
    }

    @GetMapping("/kind")
    public String kindMain(Kind kind,
                              Model model){
        Iterable<Kind> ListKind = kindRepository.findAll();
        model.addAttribute("listKind", ListKind);
        Iterable<Clas> clas = classRepository.findAll();
        model.addAttribute("clasList", clas);
        return "kind";
    }

    @PostMapping("/kind")
    public String kindAdd(@Valid Kind kind,
                          @RequestParam String name,
                             @RequestParam String clasName,
                             BindingResult result){
        if(result.hasErrors())
            return ("kind");
        Clas clas = classRepository.findByName(clasName);
        kind = new Kind(name, clas);
        kindRepository.save(kind);
        return "redirect:/kind";
    }

    @GetMapping("kind/delete/{id}")
    public String kindDelete(@PathVariable long id) {
        kindRepository.deleteById(id);
        return("redirect:/kind");
    }
}
