package com.jsp.academicDesk.service;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.UserResponse;
import com.jsp.academicDesk.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    AuthResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    Student loadStudentByEmail(String username);

    List<UserResponse> getAllEmployee();
}
