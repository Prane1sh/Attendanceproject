package com.iamneo.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iamneo.security.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value = "SELECT * FROM Student WHERE dept_name = ?1 AND class_year = ?2 AND section = ?3", nativeQuery = true)
    List<Student> findStudentsByDepartmentAndClassYearAndSection(String department, String classYear, String section);
   
}
