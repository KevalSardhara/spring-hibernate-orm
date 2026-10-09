package com.hibernate.javaSpringHibernate.service;

import com.hibernate.javaSpringHibernate.model.Student;
import com.hibernate.javaSpringHibernate.repository.StudentRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new RuntimeException("Student not found!");
        }
        return student;
    }

    @Transactional
    public void updateStudent(Student student, Long id) {
        Student getStudent = studentRepository.findById(id);

        if(getStudent == null) {
            throw new RuntimeException("Student not found");
        }
        getStudent.setName(student.getName());
        getStudent.setAge(student.getAge());
        getStudent.setEmail(student.getEmail());
    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);
        if(student == null) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.delete(student);
    }
}
