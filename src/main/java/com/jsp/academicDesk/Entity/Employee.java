package com.jsp.academicDesk.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_id_seq")
    @SequenceGenerator(name = "student_id_seq",initialValue = 100000,allocationSize = 1)
    private int employeeId;
    @Size(min = 3,message = "minimum 3 character required")
    private String name;
    @Column(unique = true)
    @Email(message = "Invalid Email")
    private String email;
    @Size(min = 10,max = 10,message = "valid phone number")
    private String phone;

    private String role;

    private String password;
    private LocalDate dateOfBirth;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
