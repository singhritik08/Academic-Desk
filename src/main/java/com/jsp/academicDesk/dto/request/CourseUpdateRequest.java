package com.jsp.academicDesk.dto.request;

import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class CourseUpdateRequest {
    private String courseName;
    private double courseFee;
    private String courseDuration;
}
