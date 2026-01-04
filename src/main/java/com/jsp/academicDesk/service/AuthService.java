package com.jsp.academicDesk.service;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.StudentResponse;
import com.jsp.academicDesk.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {

    AuthResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);

    List<StudentResponse> getAllStudents();

    Student loadStudentByEmail(String email);
}
