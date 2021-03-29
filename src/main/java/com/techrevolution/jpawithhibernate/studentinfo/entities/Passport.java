package com.techrevolution.jpawithhibernate.studentinfo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passport")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonIgnore
    private Student student;
}
