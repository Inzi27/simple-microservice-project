package io.inzi.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inzi.studentservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
