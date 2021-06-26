package io.inzi.microservices.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.inzi.microservices.departmentservice.model.Department;
import io.inzi.microservices.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long id, Department department) {
        Department dep = departmentRepository.findById(id).get();
        dep.setDepartmentId(id);
        dep.setDepartmentName(StringUtils.hasText(department.getDepartmentName())?department.getDepartmentName():dep.getDepartmentName());
        dep.setDepartmentCode(StringUtils.hasText(department.getDepartmentCode())?department.getDepartmentCode():dep.getDepartmentCode());
        return departmentRepository.save(dep);
    }

    public void removeDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    
}
