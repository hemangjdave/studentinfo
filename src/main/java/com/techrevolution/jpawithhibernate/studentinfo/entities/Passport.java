package com.techrevolution.jpawithhibernate.studentinfo.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(
            name = "passportnumber",
            nullable = false,
            unique = true,
            columnDefinition = "varchar(50)"
    )
    private String passportNumber;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "passport")
    private Student student;
}
