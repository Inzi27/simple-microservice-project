package io.inzi.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.inzi.studentservice.model.Student;
import io.inzi.studentservice.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student ){

        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){

        return studentService.getStudent(id);

    }
}
