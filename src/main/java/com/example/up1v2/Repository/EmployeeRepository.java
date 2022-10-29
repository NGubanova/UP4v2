package com.example.up1v2.Repository;

import com.example.up1v2.Models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findByNameContaining(String name);
    Employee findByUsername(String username);
}
