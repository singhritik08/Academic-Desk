package com.jsp.academicDesk.repository;

import com.jsp.academicDesk.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Object> findByEmail(String email);
}
