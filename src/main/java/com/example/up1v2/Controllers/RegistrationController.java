package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Employee;
import com.example.up1v2.Models.Role;
import com.example.up1v2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String reg(Employee employee) {
        return ("registration");
    }

    @PostMapping("/registration")
    public String reg(@Valid Employee employee, BindingResult result,
                      Model model) {

        if (result.hasErrors())
            return ("registration");
        else if (employeeRepository.findByUsername(employee.getUsername()) != null) {
            model.addAttribute("error", "Логин занят!");
            return ("registration");
        }

        employee.setActive(true);
        employee.setRoles(Collections.singleton(Role.USER));
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));

        employeeRepository.save(employee);

        return ("redirect:/login");
    }
}
