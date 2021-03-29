package com.techrevolution.jpawithhibernate.studentinfo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;

    @Column(
            name = "coursename",
            nullable = false,
            columnDefinition = "varchar(50)"
    )
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private Set<Student> students;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Review> reviews;

    @PrePersist
    private void assignReferences() {
        if (reviews != null) {
            reviews.forEach(review -> review.setCourse(this));
        }
    }
}