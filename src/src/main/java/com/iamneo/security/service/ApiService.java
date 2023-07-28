package com.iamneo.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.security.entity.Project;
import com.iamneo.security.repository.ProjectRepository;

@Service
public class ApiService {
    @Autowired
    private ProjectRepository projectRepository;
    public List<Project> getAllStudents() {
        return projectRepository.findAll();
    }
    public Project getStudentById(Integer id) {
        return projectRepository.findById(id).get();
    }
    public boolean createStudent(Project student) {
        return projectRepository.save(student) != null? true:false;
    }
    public Project updateStudent(Integer id, Project student) {
        Project stu = projectRepository.findById(id).get();
        stu.setUsername(student.getUsername());
        
      return projectRepository.save(stu);
    }
    public boolean deleteStudent(Integer id) {
        if(projectRepository.findById(id).isPresent()){
            projectRepository.deleteById(id);
          return true;
        } 
        return false;
    }
}