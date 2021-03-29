package com.techrevolution.jpawithhibernate.studentinfo.controller;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Course;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Passport;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Student;
import com.techrevolution.jpawithhibernate.studentinfo.repository.StudentRepoWithEntityManager;
import com.techrevolution.jpawithhibernate.studentinfo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentRepoWithEntityManager entityManager;

    @GetMapping
    public List<Student> getStudentList() {
        return entityManager.getAllStudent();
    }

    @PostMapping("/{studentId}")
    public Student createPassportForStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Passport passport
    ) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = optionalStudent.orElse(null);
        assert student != null;
        student.setPassport(passport);
        return studentRepository.save(student);
    }

    @PostMapping("/{studentId}/course")
    @Transactional
    public Student createCourseForStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Course course
    ) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = optionalStudent.orElse(null);
        assert student != null;
        Set<Course> courses = Optional.of(course).stream().collect(Collectors.toSet());
        student.setCourses(courses);
        return studentRepository.save(student);
    }

    @PostMapping("/{studentId}/courses")
    public Student createCoursesForStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Set<Course> courses
    ) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Student student = optionalStudent.orElse(null);
        Set<Course> savedCourse = student.getCourses();
        savedCourse.addAll(courses);
        student.setCourses(savedCourse);
        return studentRepository.save(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId) {
        return entityManager.getStudentById(studentId);
    }

    @GetMapping("/{studentId}/passport")
    @Transactional
    public Passport getPassportForStudent(@PathVariable("studentId") Long studentId) {
        return entityManager.getPassportByStudentId(studentId);
    }

    @GetMapping("/{studentId}/courses")
    public Set<Course> getCoursesOfStudent(@PathVariable("studentId") Long studentId) {
        return entityManager.getCoursesOfStudent(studentId);
    }
}
