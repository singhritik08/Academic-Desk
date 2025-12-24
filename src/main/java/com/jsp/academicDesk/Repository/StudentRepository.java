package com.jsp.academicDesk.Repository;

import com.jsp.academicDesk.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
