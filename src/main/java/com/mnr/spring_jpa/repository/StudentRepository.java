package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //you have just to give definition in Camel case
    public List<Student> findByFirstName(String firstName);

    //student who match some caracteria
    List<Student>  findByFirstNameContaining(String name);

    //not null
    List<Student> findByLastNameNotNull();

    //embedded attribute
    List<Student> findAllByGuardianName(String guardianName);


    Student findByFirstNameAndLastName(String firstName,String lastName);


    //query
    @Query(" select s from Student s where s.emailId = ?1 ")
    Student getStudentByEmailAdress(String EmailId);

    @Query(" select s.firstName from Student s where s.emailId = ?1 ")
    String getStudentFirstNameByEmailAdress(String EmailId);
}
