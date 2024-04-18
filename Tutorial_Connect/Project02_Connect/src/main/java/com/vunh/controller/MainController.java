package com.vunh.controller;

import com.vunh.entity.Employee;
import com.vunh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.lang.StringTemplate.STR;

@Controller
public class MainController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("limit") Optional<Integer> limit) {
        Pageable pageable = PageRequest.of(page.orElse(0), limit.orElse(5));
        model.addAttribute("limit", limit.orElse(5));
        model.addAttribute("NewName", new Employee());
        model.addAttribute("employees", this.employeeService.getAll(pageable));
        return "index";
    }

    @PostMapping("/update_name")
    String updateName(@Validated @ModelAttribute("NewName") Employee employee, BindingResult result, Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("limit") Optional<Integer> limit) {
        if (result.hasErrors()) {
            Pageable pageable = PageRequest.of(page.orElse(0), limit.orElse(5));
            model.addAttribute("limit", limit.orElse(5));
            model.addAttribute("NewName", employee);
            model.addAttribute("employees", this.employeeService.getAll(pageable));
            return "index";
        }
        this.employeeService.updateFullName(employee);
        System.out.println("update");
        return "redirect:/";
    }

    @RequestMapping("/add")
    String create(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("ListCountry", this.employeeService.getAllCountry());
        return "create";
    }

    @PostMapping("/add")
    String store(Model model, @Validated @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            model.addAttribute("ListCountry", this.employeeService.getAllCountry());
            return "create";
        }
        this.employeeService.add(employee);
        return "redirect:/";
    }

    @RequestMapping("/update")
    String edit(Model model, @RequestParam("id") Integer id) {
        Employee emp = this.employeeService.getById(id).orElse(new Employee());
        model.addAttribute("employee", emp);
        model.addAttribute("ListCountry", this.employeeService.getAllCountry());
        return "update";
    }

    @PostMapping("/update")
    String update(Model model, @Validated @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            model.addAttribute("ListCountry", this.employeeService.getAllCountry());
            return "update";
        }
        this.employeeService.add(employee);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(Model model , @RequestParam("id") Integer id, @RequestParam("page") Optional<Integer> page, @RequestParam("limit") Optional<Integer> limit) {
        this.employeeService.delete(id);
        return STR."redirect:/?page=\{page.orElse(0)}&limit=\{limit.orElse(5)}";
    }
}
