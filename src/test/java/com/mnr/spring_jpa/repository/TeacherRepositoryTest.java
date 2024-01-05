package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Course;
import com.mnr.spring_jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void  saveTeacher(){

        Course coursePython=
                Course.builder()
                        .title("python")
                        .credit(5)
                        .build();
        Course courseDBA=
                Course.builder()
                        .title("DBA")
                        .credit(6)
                        .build();

        Teacher teacher=
                Teacher.builder()
                        .firstName("amineT")
                        .lastName("aloaui")
                        //.courses(List.of(courseDBA,coursePython))

                .build();

        teacherRepository.save(teacher);

    }

}