package com.vunh.controller.api.student;

import com.vunh.entity.Student;
import com.vunh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/student")
public class StudentController_API {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return this.studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id) {
        this.studentService.deleteStudent(id);
    }
}
