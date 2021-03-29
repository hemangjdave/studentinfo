package com.techrevolution.jpawithhibernate.studentinfo.repository;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Course;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Passport;
import com.techrevolution.jpawithhibernate.studentinfo.entities.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class StudentRepoWithEntityManager {

    private final EntityManager entityManager;

    public List<Student> getAllStudent(){
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    public Student getStudentById(Long studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Transactional
    public Passport getPassportByStudentId(Long studentId) {
        Student student = entityManager.find(Student.class, studentId);
        return student.getPassport();
    }

    @Transactional
    public Set<Course> getCoursesOfStudent(Long studentId) {
        Student student = entityManager.find(Student.class, studentId);
        return student.getCourses();
    }
}
