package com.techrevolution.jpawithhibernate.studentinfo.controller;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Course;
import com.techrevolution.jpawithhibernate.studentinfo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
