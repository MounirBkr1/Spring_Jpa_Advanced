package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Guardian;
import com.mnr.spring_jpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student= Student.builder()
                .emailId("jjjjdj@gmzil.com")
                .firstName("mounir")
                .lastName("bkr")
                //.guardianName("kilom")
                //.getGuardianEmail("kilom@gmailcom")
                //.getGuardianMobile("0425144225")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                .email("guard-alex@gmail")
                .name("guardAlex")
                .mobile("02154222")
                .build();
        Student student= Student.builder()
                .emailId("alex@gmzil.com")
                .firstName("alex")
                .lastName("xel")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudents(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("studentList= "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students= studentRepository.findByFirstName("alex");
        System.out.println("**student= "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students= studentRepository.findByFirstNameContaining("ou");
        System.out.println("**student= "+students);
    }

    @Test
    public void printStudentLastNameNotNull(){
        List<Student> students= studentRepository.findByLastNameNotNull();
        System.out.println("**student last name not null are = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students= studentRepository.findAllByGuardianName("kilom");
        System.out.println("**student by guardian= "+students);
    }

    @Test
    public void printStudentByEmailAdress(){
        Student student= studentRepository.getStudentByEmailAdress("alex@gmzil.com");
        System.out.println("**student by email= "+student);
    }

    @Test
    public void printStudentByFirstNameByEmailAdress(){
        String firstName= studentRepository.getStudentFirstNameByEmailAdress("alex@gmzil.com");
        System.out.println("**student firstName by email= "+firstName);
    }
}