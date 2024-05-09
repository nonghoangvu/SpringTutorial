package com.vunh.controller;

import com.vunh.entity.Employee;
import com.vunh.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    List<Employee> index() {
        return this.employeeRepo.findAll();
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Integer id) {
        this.employeeRepo.deleteById(id);
        return "Remove successfully";
    }

    @PostMapping
    Employee store(@RequestBody Employee employee) {
        return this.employeeRepo.save(employee);
    }

    @PutMapping
    Employee update(@RequestBody Employee employee) {
        return this.employeeRepo.save(employee);
    }
}
