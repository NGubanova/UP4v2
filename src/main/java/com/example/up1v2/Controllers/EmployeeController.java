package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Employee;
import com.example.up1v2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("")
    public String employeeMain(Model model){
        Iterable<Employee> listEmployee = employeeRepository.findAll();
        model.addAttribute("listPeople", listEmployee);
        return "employee/index";
    }

    @GetMapping("/add")
    public String employeeAddView(Employee employee){
        return "employee/action";
    }

    @PostMapping("/add")
    public String employeeAdd(@Valid Employee employee,
                              BindingResult result){
        if(result.hasErrors())
            return ("employee/action");

        employeeRepository.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("/details/{id}")
    public String employeeDetails(Model model,
                             @PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        model.addAttribute("people", employee);
        return ("/employee/details");
    }

    @GetMapping("/edit/{id}")
    public String employeeEdit(Model model,
                          @PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        model.addAttribute("employee", employee);
        return("/employee/edit");
    }

    @PostMapping("/edit/{id}")
    public String employeeEdit(@Valid Employee employee,
                               BindingResult result) {
        if(result.hasErrors())
            return("/employee/edit");

        employeeRepository.save(employee);

        return("redirect:/employee/details/" + employee.getId());
    }

    @GetMapping("/delete/{id}")
    public String employeeDelete(@PathVariable long id) {
        employeeRepository.deleteById(id);
        return("redirect:/employee");
    }

    @GetMapping("/employee/filter")
    public String employeeFilter(@RequestParam String searchName,
                            Model model){
        List<Employee> employee =employeeRepository.findByNameContaining(searchName);
        model.addAttribute("listPeople", employee);
        return "employee/index";
    }
}
