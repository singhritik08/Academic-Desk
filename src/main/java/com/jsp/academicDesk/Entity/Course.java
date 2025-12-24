package com.jsp.academicDesk.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "course_id_seq")
    @SequenceGenerator(name = "course_id_seq",initialValue = 100000,allocationSize = 1)
    private int courseId;
    @Column(unique = true,nullable = false)
    private String courseName;
    @Column(nullable = false)
    private double courseFee;

}
