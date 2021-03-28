package com.techrevolution.jpawithhibernate.studentinfo.controller;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Student;
import com.techrevolution.jpawithhibernate.studentinfo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }
}
