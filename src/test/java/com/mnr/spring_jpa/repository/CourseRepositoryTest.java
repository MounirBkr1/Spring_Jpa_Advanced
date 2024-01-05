package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Course;
import com.mnr.spring_jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private  CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses=
                courseRepository.findAll();
        System.out.println("***courses= "+ courses);

    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("biancaT")
                .lastName("sing")
                .build();

        Course course= Course.builder()
                .title("sql")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);


    }

}