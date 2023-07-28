package com.iamneo.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.security.entity.Project;
import com.iamneo.security.entity.Task;
import com.iamneo.security.repository.ProjectRepository;
import com.iamneo.security.repository.TaskRepository;

@Service
public class TaskApiService {
    @Autowired
    private TaskRepository projectRepository;
    public List<Task> getAllStudents1() {
        return projectRepository.findAll();
    }
    public Task getStudentById1(Integer id) {
        return projectRepository.findById(id).get();
    }
    public boolean createStudent1(Task student) {
        return projectRepository.save(student) != null? true:false;
    }
    public Task updateStudent1(Integer id, Task student) {
        Task stu = projectRepository.findById(id).get();
        stu.setProjectname(student.getProjectname());
        
      return projectRepository.save(stu);
    }
    public boolean deleteStudent1(Integer id) {
        if(projectRepository.findById(id).isPresent()){
            projectRepository.deleteById(id);
          return true;
        } 
        return false;
    }
}