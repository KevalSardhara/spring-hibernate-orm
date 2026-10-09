package com.hibernate.javaSpringHibernate.controller;

import com.hibernate.javaSpringHibernate.model.Student;
import com.hibernate.javaSpringHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.CREATED).body(studentList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(student, id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student update student successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student delete successfully");
    }
}
