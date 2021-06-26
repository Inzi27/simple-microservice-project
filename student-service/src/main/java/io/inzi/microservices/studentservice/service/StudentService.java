package io.inzi.microservices.studentservice.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import io.inzi.microservices.studentservice.model.Department;
import io.inzi.microservices.studentservice.model.Student;
import io.inzi.microservices.studentservice.model.UserResponse;
import io.inzi.microservices.studentservice.repository.StudentRepository;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserResponse response;

    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student student) {
        Student stud = studentRepository.findById(id).get();
        stud.setStudentId(id);
        stud.setName(StringUtils.hasText(student.getName())?student.getName():stud.getName());
        stud.setEmail(StringUtils.hasText(student.getEmail())?student.getEmail():stud.getEmail());
        stud.setDepartmentId(Objects.isNull(student.getDepartmentId())?student.getDepartmentId():stud.getDepartmentId());
        return studentRepository.save(stud);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public UserResponse getStudentWithDepartment(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        Department department = 
            restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + student.getDepartmentId(), Department.class);
        response.setStudent(student);
        response.setDepartment(department);
        return response;
    }



}
