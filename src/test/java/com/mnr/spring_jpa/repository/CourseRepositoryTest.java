package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Course;
import com.mnr.spring_jpa.entities.Student;
import com.mnr.spring_jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;


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

    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecords=
                PageRequest.of(0,3);

        PageRequest firstPageWithTwoRecords=
                PageRequest.of(1,2);

        List<Course> courses= courseRepository.findAll(firstPageWithTwoRecords).getContent();


        Long totalElement=
                courseRepository.findAll( firstPageWithThreeRecords).getTotalElements();

        Long totalPages=
                Long.valueOf(courseRepository.findAll( firstPageWithThreeRecords).getTotalPages());

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElement = " + totalElement);

        System.out.println("courses= "+ courses);

    }

    @Test
    public void findAllSorting(){
        PageRequest sortByTitle=
                PageRequest.of(0,2, Sort.by("title"));

        PageRequest sortByCreditDesc=
                PageRequest.of(0,2, Sort.by("credit").descending());

        PageRequest sortByTitleAndCredirDesc=
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                        );

        List<Course> coursesByTitle=
                courseRepository.findAll(sortByTitle).getContent();

        List<Course> coursesByCredit=
                courseRepository.findAll(sortByCreditDesc).getContent();

        List<Course> coursesByTitleAndCredit=
                courseRepository.findAll(sortByTitleAndCredirDesc).getContent();


        System.out.println("coursesByTitle = " + coursesByTitle);
        System.out.println("coursesByCredit = " + coursesByCredit);
        System.out.println("coursesByTitleAndCredit = " + coursesByTitleAndCredit);

    }

    //pagination on repository
//    @Test
//    private void printFindByTitleContaining(){
//        Pageable firstPageTnRecords=
//                (Pageable) PageRequest.of(0,10);
//
//        List<Course> courses=
//                courseRepository.findByTitleContaining("j",firstPageTnRecords).getContent();
//
//        System.out.println("courses = " + courses);
//    }


    @Test
    private void saveCourseWihStudentAndTeacher(){
        Teacher teacher= Teacher.builder()
                .firstName("ahmed")
                .lastName("morgan")
                .build();

        Student student= Student.builder()
                .firstName("amine")
                .lastName("bakhoya")
                .emailId("bakhoya@gmail")
                .build();

        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);
        courseRepository.save(course);

    }

}