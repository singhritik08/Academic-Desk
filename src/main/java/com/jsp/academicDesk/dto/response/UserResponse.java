package com.jsp.academicDesk.dto.response;

import com.jsp.academicDesk.entity.Role;
import com.jsp.academicDesk.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private int id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private String password;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponse(Student student) {
        this.id = student.getStudentId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.phone = student.getPhone();
        this.role = student.getRole();
        this.password = student.getPassword();
        this.dateOfBirth = student.getDateOfBirth();
        this.createdAt = student.getCreatedAt();
        this.updatedAt = student.getUpdatedAt();
    }



}
