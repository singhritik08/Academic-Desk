package com.jsp.academicDesk.service.impl;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.UserResponse;
import com.jsp.academicDesk.entity.Employee;
import com.jsp.academicDesk.entity.Role;
import com.jsp.academicDesk.entity.Student;
import com.jsp.academicDesk.exception.StudentException;
import com.jsp.academicDesk.exception.UserNotFoundException;
import com.jsp.academicDesk.repository.EmployeeRepository;
import com.jsp.academicDesk.security.JwtService;
import com.jsp.academicDesk.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;


    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        if (employeeRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new StudentException("Employee already exists");
        }

        Employee employee = Employee.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .phone(registerRequest.getPhone())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.valueOf(String.valueOf(registerRequest.getRole())))
                .dateOfBirth(registerRequest.getDateOfBirth())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        AuthResponse authResponse = AuthResponse.builder()
                .name(savedEmployee.getName())
                .email(savedEmployee.getEmail())
                .id(savedEmployee.getEmployeeId())
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
    public List<UserResponse> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> new UserResponse(
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getEmail(),
                        employee.getPhone(),
                        employee.getRole(),
                        employee.getPassword(),
                        employee.getDateOfBirth(),
                        employee.getCreatedAt(),
                        employee.getUpdatedAt()
                ))
                .toList();
    }

    @Override
    public Student loadStudentByEmail(String email) {

        return (Student) employeeRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Employee not found "));
    }

}
