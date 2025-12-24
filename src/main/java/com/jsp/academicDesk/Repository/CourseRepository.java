package com.jsp.academicDesk.Repository;

import com.jsp.academicDesk.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
