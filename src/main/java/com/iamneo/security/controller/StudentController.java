package com.iamneo.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.security.entity.Student;
import com.iamneo.security.service.StudentService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/auth/students")
public class StudentController {
	  private final StudentService studentService;

	    @Autowired
	    public StudentController(StudentService studentService) {
	        this.studentService = studentService;
	    }

	    @GetMapping
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public Student getStudentById(@PathVariable int id) {
	        return studentService.getStudentById(id);
	    }

	    @GetMapping("/filter/{department}/{classYear}/{section}")
	    public ResponseEntity<List<Student>> getStudentsByFilter(
	            @PathVariable("department") String department,
	            @PathVariable("classYear") String classYear,
	            @PathVariable("section") String section) {
	        List<Student> students = studentService.getStudentsByFilter(department, classYear, section);
	        if (students.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(students);
	    }

	    @PostMapping
	    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
	        int studentId = student.getStu_id();
	    
	        // Check if the student ID already exists in the database
	        Student existingStudent = studentService.getStudentById(studentId);
	    
	        if (existingStudent != null) {
	          // If a student with the same ID exists, return a conflict status response
	          return ResponseEntity.status(HttpStatus.CONFLICT).build();
	        } else {
	          // If the student ID is unique, add the student to the database
	          Student addedStudent = studentService.addStudent(student);
	          return ResponseEntity.status(HttpStatus.CREATED).body(addedStudent);
	        }
	    }

	    @PutMapping("/{id}")
	    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
	        return studentService.updateStudent(id, student);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteStudent(@PathVariable int id) {
	        studentService.deleteStudent(id);
	    }
}

