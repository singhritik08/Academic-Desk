package com.jsp.academicDesk.service;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.UserResponse;
import com.jsp.academicDesk.entity.Student;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {

    AuthResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);

    List<UserResponse> getAllStudents();

    Student loadStudentByEmail(String email);

    Page<UserResponse> fetchAllStudents(int page, int size);
}
