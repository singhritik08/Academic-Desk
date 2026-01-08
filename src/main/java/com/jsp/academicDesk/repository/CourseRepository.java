package com.jsp.academicDesk.repository;

import com.jsp.academicDesk.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    boolean findBycourseName(String courseName);
}
