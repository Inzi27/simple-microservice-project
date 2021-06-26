package io.inzi.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inzi.studentservice.model.Student;
import io.inzi.studentservice.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }



}
