package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    //native query

    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    //Query native named params

    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNamaParam(@Param("emailId") String emailId);

    //update or modified data: @transational & @Modifying annotation
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student  set firstName= ?1 where email_adress= ?1",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);

    //jpa one to one relationship





}
