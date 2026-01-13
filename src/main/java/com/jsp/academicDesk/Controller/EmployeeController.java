package com.jsp.academicDesk.Controller;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.UserResponse;
import com.jsp.academicDesk.entity.Student;
import com.jsp.academicDesk.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin("*")

public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.register(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.login(loginRequest));
    }
    @GetMapping("/me")
    public ResponseEntity<Student> me(Authentication authentication){
        String username=authentication.getName();
        System.out.println(username);
        Student student = employeeService.loadStudentByEmail(username);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllEmployee() {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.getAllEmployee());
    }

}
