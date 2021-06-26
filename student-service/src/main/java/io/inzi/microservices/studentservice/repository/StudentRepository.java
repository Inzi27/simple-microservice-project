package io.inzi.microservices.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inzi.microservices.studentservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
