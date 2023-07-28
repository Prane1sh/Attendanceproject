package com.iamneo.security.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.security.entity.Project;
import com.iamneo.security.entity.Task;
import com.iamneo.security.service.ApiService;
import com.iamneo.security.service.TaskApiService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/pro")
public class TaskController {
    @Autowired
    private TaskApiService apiService;
    @GetMapping("/task/")
    public List<Task> getAllStudents() {
        return apiService.getAllStudents1();
    }
    @GetMapping("/task/{id}")
    public Task getStudentById(@PathVariable Integer id) {
        return apiService.getStudentById1(id);
    }
    @PostMapping("/task")
    public boolean createStudent(@RequestBody Task student) {
        return apiService.createStudent1(student);
    }
    @PutMapping("/task/{id}")
    public Task updateStudent( @RequestBody Task student,@PathVariable Integer id) {
        return apiService.updateStudent1(id, student);
    }
    @DeleteMapping("/task/{id}")
    public boolean deleteStudent(@PathVariable Integer id) {
       return apiService.deleteStudent1(id);
    }
}