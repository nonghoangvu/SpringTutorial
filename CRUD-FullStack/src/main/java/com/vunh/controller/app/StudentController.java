package com.vunh.controller.app;

import com.vunh.entity.Student;
import com.vunh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    String index(Model model) {
        model.addAttribute("VIEW", "home.jsp");
        model.addAttribute("students", this.studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/{id}")
    String deleteStudent(@PathVariable Integer id) {
        this.studentService.deleteStudent(id);
        return "redirect:/app/student";
    }

    @GetMapping("/update/{id}")
    String editStudent(@PathVariable Integer id, Model model) {
        model.addAttribute("student", this.studentService.getStudentById(id));
        model.addAttribute("VIEW", "edit.jsp");
        return "index";
    }

    @PostMapping("/update")
    String updateStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("VIEW", "edit.jsp");
            return "index";
        }
        this.studentService.updateStudent(student);
        return "redirect:/app/student";
    }

    @GetMapping("/add")
    String createStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("VIEW", "add.jsp");
        return "index";
    }

    @PostMapping("/add")
    String storeStudent(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("VIEW", "add.jsp");
            return "index";
        }
        this.studentService.addStudent(student);
        return "redirect:/app/student";
    }
}
