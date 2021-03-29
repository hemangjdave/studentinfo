package com.techrevolution.jpawithhibernate.studentinfo.repository;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course , Long> {
}