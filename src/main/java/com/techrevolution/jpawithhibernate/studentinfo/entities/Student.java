package com.techrevolution.jpawithhibernate.studentinfo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            columnDefinition = "int",
            nullable = false,
            unique = true
    )
    private Long id;

    @Column(
            name = "firstname",
            columnDefinition = "varchar(50)",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "lastname",
            columnDefinition = "varchar(50)",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            columnDefinition = "varchar(75)",
            nullable = false
    )
    private String email;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnore
    private Passport passport;

}
