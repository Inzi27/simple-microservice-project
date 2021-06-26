package io.inzi.microservices.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.inzi.microservices.departmentservice.model.Department;
import io.inzi.microservices.departmentservice.service.DepartmentService;

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long id){
        return departmentService.getDepartment(id);
    }
    

    @GetMapping("/departments")
    public List<Department> saveDepartment(){
        return departmentService.getDepartments();
    }

    @PutMapping("departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("departments/{id}")
    public String removeDepartment(@PathVariable("id") Long id){
        departmentService.removeDepartment(id);
        return "Department with departmentId " + id + " has been removed!";
    }

    
}
