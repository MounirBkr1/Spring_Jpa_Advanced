package com.mnr.spring_jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
        name = "emailid_unique",
        columnNames = "email_address"
))

public class Student {

    @Id
    @SequenceGenerator(
            name ="student_sequence" ,
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "student_sequence")
    private Long Id;

    private String firstName;
    private String lastName;

    @Column(
            name="email_address",
            nullable = false
    )
    private String emailId;


    //add guardian as a property of student
    @Embedded
    private Guardian guardian;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return Id != null && Objects.equals(Id, student.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
