package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    //pagination
//    Page<Course> findByTitleContaining(
//            String title,
//            Pageable pageable
//    );
}
