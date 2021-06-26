package io.inzi.microservices.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.inzi.microservices.studentservice.model.Student;
import io.inzi.microservices.studentservice.model.UserResponse;
import io.inzi.microservices.studentservice.service.StudentService;

@RestController
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student ){
        return studentService.saveStudent(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student ){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Student with studentId " + id + " has been removed!";
    }

    @GetMapping("/studentDetails/{id}")
    public UserResponse getStudentWithDepartment(@PathVariable("id") Long studentId){
        return studentService.getStudentWithDepartment(studentId);
    }

}
