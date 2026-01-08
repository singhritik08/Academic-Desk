package com.jsp.academicDesk.Controller;

import com.jsp.academicDesk.dto.request.LoginRequest;
import com.jsp.academicDesk.dto.request.RegisterRequest;
import com.jsp.academicDesk.dto.response.AuthResponse;
import com.jsp.academicDesk.dto.response.LoginResponse;
import com.jsp.academicDesk.dto.response.UserResponse;
import com.jsp.academicDesk.entity.Student;
import com.jsp.academicDesk.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/academicDesk/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.login(loginRequest));
    }
    @GetMapping("/me")
    public ResponseEntity<Student> me(Authentication authentication){
        String username=authentication.getName();
        System.out.println(username);
        Student student = authService.loadStudentByEmail(username);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(authService.getAllStudents());
    }

    @GetMapping("/fetch/all/students")
    public ResponseEntity<Page<UserResponse>> fetchAllStudents(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(authService.fetchAllStudents(page, size));
    }

}
