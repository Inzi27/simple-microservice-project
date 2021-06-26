package io.inzi.microservices.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.inzi.microservices.departmentservice.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
