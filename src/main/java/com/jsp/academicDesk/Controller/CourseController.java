package com.jsp.academicDesk.Controller;

import com.jsp.academicDesk.entity.Course;
import com.jsp.academicDesk.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/create/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(course));
    }



}
