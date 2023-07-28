package com.iamneo.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.security.entity.Student;
import com.iamneo.security.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getStudentsByFilter(String department, String classYear, String section) {
        return studentRepository.findStudentsByDepartmentAndClassYearAndSection(department, classYear, section);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setStu_name(updatedStudent.getStu_name());
            student.setStu_gender(updatedStudent.getStu_gender());
            student.setStu_phno(updatedStudent.getStu_phno());
            student.setClass_year(updatedStudent.getClass_year());
            student.setSection(updatedStudent.getSection());
            student.setDept_name(updatedStudent.getDept_name());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}

