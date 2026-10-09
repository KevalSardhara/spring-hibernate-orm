package com.hibernate.javaSpringHibernate.repository;

import com.hibernate.javaSpringHibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // create and add if not exists
    public void save(Student student) {
        entityManager.persist(student);
    }

    // getAll with listArray
    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s").getResultList();
    }

    // find by id
    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    // delete
    public void delete(Student student) {
        entityManager.remove(student);
    }

    // update
//    public void update(Student student) {
//        entityManager.merge(student);
//    }
}
