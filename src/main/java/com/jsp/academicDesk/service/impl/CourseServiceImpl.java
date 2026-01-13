package com.jsp.academicDesk.service.impl;

import com.jsp.academicDesk.dto.request.CourseUpdateRequest;
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
        if(courseRepository.existsByCourseName(courseRequest.getCourseName())){
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

    @Override
    public Course updateCourse(int courseId, CourseUpdateRequest courseUpdate) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found"));

        course.setCourseName(courseUpdate.getCourseName());
        course.setCourseFee(courseUpdate.getCourseFee());
        course.setCourseDuration(courseUpdate.getCourseDuration());

        return courseRepository.save(course);
    }

    @Override
    public boolean deleteById(int courseId) {
        if (!courseRepository.existsById(courseId)) {
            return false;
        }
        courseRepository.deleteById(courseId);
        return true;
    }

}
