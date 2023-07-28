package com.iamneo.security.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.security.entity.Contact;
import com.iamneo.security.entity.Project;
import com.iamneo.security.repository.ContactRepository;


@Service
public class ContactApiService {
    @Autowired
    private ContactRepository projectRepository;
    public List<Contact> getAllStudents2() {
        return projectRepository.findAll();
    }
    public Contact getStudentById2(Integer id) {
        return projectRepository.findById(id).get();
    }
    public boolean createStudent2(Contact student) {
        return projectRepository.save(student) != null? true:false;
    }
    public Contact updateStudent2(Integer id, Contact student) {
        Contact stu = projectRepository.findById(id).get();
        stu.setName(student.getName());
        
      return projectRepository.save(stu);
    }
    public boolean deleteStudent2(Integer id) {
        if(projectRepository.findById(id).isPresent()){
            projectRepository.deleteById(id);
          return true;
        } 
        return false;
    }
}