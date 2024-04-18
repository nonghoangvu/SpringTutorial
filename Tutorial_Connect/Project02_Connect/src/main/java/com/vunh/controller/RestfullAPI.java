package com.vunh.controller;

import com.vunh.entity.Employee;
import com.vunh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

}
