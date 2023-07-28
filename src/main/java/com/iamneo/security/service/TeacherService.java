package com.iamneo.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.security.entity.Teacher;
import com.iamneo.security.repository.TeacherRepository;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        return teacherOptional.orElse(null);
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(int id, Teacher updatedTeacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            teacher.setTeacher_name(updatedTeacher.getTeacher_name());
            teacher.setDept_name(updatedTeacher.getDept_name());
            teacher.setSubject_name(updatedTeacher.getSubject_name());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    public boolean deleteTeacher(int id) {
        // Check if the teacher with the given id exists in the database
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            // If the teacher exists, delete it from the database
            teacherRepository.deleteById(id);
            return true;
        }
        // If the teacher does not exist, return false
        return false;
    }
}
