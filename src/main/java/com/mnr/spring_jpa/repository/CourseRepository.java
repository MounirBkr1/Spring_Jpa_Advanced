package com.mnr.spring_jpa.repository;

import com.mnr.spring_jpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
