package com.example.up1v2.Controllers;

import com.example.up1v2.Models.Employee;
import com.example.up1v2.Models.Kind;
import com.example.up1v2.Models.Post;
import com.example.up1v2.Models.Role;
import com.example.up1v2.Repository.EmployeeRepository;
import com.example.up1v2.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
@PreAuthorize("hasAuthority('ADMIN')")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    PostRepository postRepository;
    @GetMapping("")
    public String employeeMain(Model model){
        Iterable<Employee> listEmployee = employeeRepository.findAll();
        model.addAttribute("listPeople", listEmployee);
        return "employee/index";
    }

    @GetMapping("/add")
    public String employeeAddView(Employee employee, Model model){
        Iterable<Role> roles = List.of(Role.values());
        model.addAttribute("roleName", roles);
        Iterable<Post> ListPost = postRepository.findAll();
        model.addAttribute("listPost", ListPost);
        return "employee/action";
    }

    @PostMapping("/add")
    public String employeeAdd(@Valid Employee employee,
                              BindingResult result){
        if(result.hasErrors())
            return ("employee/action");

        employee.setActive(true);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
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
        Iterable<Role> roles = List.of(Role.values());
        model.addAttribute("roleName", roles);
        Iterable<Post> ListPost = postRepository.findAll();
        model.addAttribute("listPost", ListPost);

        return("/employee/edit");
    }

    @PostMapping("/edit/{id}")
    public String employeeEdit(@RequestParam Long id,
                               @RequestParam String[] roles,
                               @RequestParam String username,
                               @RequestParam String name,
                               @RequestParam String listPost) {
        Post post = postRepository.findByName(listPost);
        Employee employee = employeeRepository.findById(id).orElseThrow();

        employee.getRoles().clear();
        for(String role: roles){
            employee.getRoles().add(Role.valueOf(role));
        }
        employee.setActive(true);
        employee = new Employee(name, username, post);
        employeeRepository.save(employee);
        return("redirect:/employee/details/" + employee.getId());
    }

    @GetMapping("/delete/{id}")
    public String employeeDelete(@PathVariable long id) {
        Employee employee= employeeRepository.findById(id).orElseThrow();
        employee.setActive(false);
        employeeRepository.save(employee);
        return("redirect:/employee");
    }

    @GetMapping("/filter")
    public String employeeFilter(@RequestParam String searchName,
                            Model model){
        List<Employee> employee =employeeRepository.findByNameContaining(searchName);
        model.addAttribute("listPeople", employee);
        return "employee/index";
    }
}
