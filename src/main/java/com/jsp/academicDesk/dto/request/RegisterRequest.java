package com.jsp.academicDesk.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Builder
@Valid
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

        @NotEmpty
        private String name;
        @NotBlank
        @Email
        private String email;
        @Size(min = 10,max = 10,message = "10 digits required")
        private String phone;
        private String password;
        private String role;
        private LocalDate dateOfBirth;

}
