package com.vunh.controller;

import com.vunh.entity.Employee;
import com.vunh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/employee")
@RestController
public class RestfullAPI {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    Page<Employee> index(@RequestParam("page") Optional<Integer> page, @RequestParam("limit") Optional<Integer> limit) {
        Pageable pageable = PageRequest.of(page.orElse(0), limit.orElse(5));
        return this.employeeService.getAll(pageable);
    }

    @PostMapping("/add")
    Employee store(@RequestBody Employee employee) {
        this.employeeService.add(employee);
        return employee;
    }

    @PostMapping("/update")
    Employee update(@RequestBody Employee employee) {
        this.employeeService.add(employee);
        return employee;
    }

    @GetMapping("/id-employee")
    Employee findById(@RequestParam("id") Integer id) {
        return this.employeeService.getById(id).orElseGet(Employee::new);
    }

    @GetMapping("/delete")
    String delete(@RequestParam("id") Integer id){
        this.employeeService.delete(id);
        return STR."Remove successfully id \{id}";
    }
}
