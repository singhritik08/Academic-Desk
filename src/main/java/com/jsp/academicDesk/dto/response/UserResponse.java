package com.jsp.academicDesk.dto.response;

import com.jsp.academicDesk.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
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
}
