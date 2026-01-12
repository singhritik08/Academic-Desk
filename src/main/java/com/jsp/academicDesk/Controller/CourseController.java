package com.jsp.academicDesk.Controller;

import com.jsp.academicDesk.dto.request.CourseUpdateRequest;
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

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(course));
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestParam int courseId, @RequestBody CourseUpdateRequest courseUpdate){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.updateCourse(courseId,courseUpdate));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Course> deleteCourse(@RequestParam int courseId){
        return null;
    }

}
