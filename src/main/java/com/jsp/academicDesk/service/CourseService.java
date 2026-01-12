package com.jsp.academicDesk.service;

import com.jsp.academicDesk.dto.request.CourseUpdateRequest;
import com.jsp.academicDesk.entity.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    Course createCourse(Course course);

    Course updateCourse(int courseId, CourseUpdateRequest courseUpdate);
}
