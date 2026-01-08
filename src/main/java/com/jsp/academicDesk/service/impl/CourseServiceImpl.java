package com.jsp.academicDesk.service.impl;

import com.jsp.academicDesk.entity.Course;
import com.jsp.academicDesk.exception.CourseException;
import com.jsp.academicDesk.repository.CourseRepository;
import com.jsp.academicDesk.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course createCourse(Course courseRequest) {
        if(courseRepository.findBycourseName(courseRequest.getCourseName())){
            throw new CourseException("Course already exist");
        }

        Course course = Course.builder()
                .courseName(courseRequest.getCourseName())
                .courseFee(courseRequest.getCourseFee())
                .courseDuration(courseRequest.getCourseDuration())
                .build();
        Course saveCourse = courseRepository.save(course);

        return saveCourse;
    }
}
