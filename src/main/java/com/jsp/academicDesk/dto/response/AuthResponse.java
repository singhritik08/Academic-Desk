package com.jsp.academicDesk.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private long id;
    private String name;
    private String email;
    private String tokens;

}
