package com.jsp.academicDesk.repository;

import com.jsp.academicDesk.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findByEmail(String email);
}
