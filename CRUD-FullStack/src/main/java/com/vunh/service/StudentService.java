package com.vunh.service;

import com.vunh.entity.Student;
import com.vunh.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Page<Student> getAllStudents(Pageable pageable, String q) {
        return this.studentRepository.findAll(pageable, q);
    }

    public Student getStudentById(Integer id) {
        return this.studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        this.studentRepository.deleteById(id);
    }
}
