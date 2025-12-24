package com.jsp.academicDesk.Repository;

import com.jsp.academicDesk.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
