package com.jsp.academicDesk.service.impl;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.UserResponse;
import com.jsp.academicDesk.entity.Role;
import com.jsp.academicDesk.entity.Student;

import com.jsp.academicDesk.exception.UserNotFoundException;
import com.jsp.academicDesk.repository.StudentRepository;
import com.jsp.academicDesk.security.JwtService;
import com.jsp.academicDesk.service.AuthService;
import com.jsp.academicDesk.exception.StudentException;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        if (studentRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new StudentException("Student already exists");
        }

        Student student = Student.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.valueOf(String.valueOf(registerRequest.getRole())))
                .dateOfBirth(registerRequest.getDateOfBirth())
                .build();

        Student savedStudent = studentRepository.save(student);

        AuthResponse authResponse = AuthResponse.builder()
                .name(savedStudent.getName())
                .email(savedStudent.getEmail())
                .id(savedStudent.getStudentId())
                .build();

        return authResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Student student = (Student) authentication.getPrincipal();

        String token = jwtService.generateToken(student);

        return LoginResponse.builder()
                .token(token)
                .build();
    }
    @Override
    public List<UserResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new UserResponse(
                        student.getStudentId(),
                        student.getName(),
                        student.getEmail(),
                        student.getPhone(),
                        student.getRole(),
                        student.getPassword(),
                        student.getDateOfBirth(),
                        student.getCreatedAt(),
                        student.getUpdatedAt()
                ))
                .toList();
    }

    @Override
    public Student loadStudentByEmail(String email) {

            return studentRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException("Student not found "));
    }



    @Override
    public Page<UserResponse> fetchAllStudents(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable)
                .map(student -> new UserResponse(student));
    }


}

