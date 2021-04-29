package com.example.demo.services;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> save(Student student) {
        try {
            studentRepository.save(student);
            return getAllStudents();
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }
}
