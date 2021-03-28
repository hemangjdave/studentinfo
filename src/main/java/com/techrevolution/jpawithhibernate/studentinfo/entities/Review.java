package com.techrevolution.jpawithhibernate.studentinfo.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "review")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "rating",
            columnDefinition = "int"
    )
    private int rating;

    @Column(
            name = "review",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String review;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Course course;
}
