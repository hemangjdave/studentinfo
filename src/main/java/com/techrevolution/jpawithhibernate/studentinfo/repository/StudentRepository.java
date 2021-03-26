package com.techrevolution.jpawithhibernate.studentinfo.repository;

import com.techrevolution.jpawithhibernate.studentinfo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {
}
