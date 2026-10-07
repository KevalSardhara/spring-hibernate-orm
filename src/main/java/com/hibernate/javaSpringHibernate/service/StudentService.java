package com.hibernate.javaSpringHibernate.service;

import com.hibernate.javaSpringHibernate.model.Student;
import com.hibernate.javaSpringHibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        studentRepository.findAll();
        return null;
    }

    public void getStudentById(Long id) {
        studentRepository.findById(id);
    }

    public void updateStudent(Student student, Long id) {
        studentRepository.update(student, id);
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }



}
