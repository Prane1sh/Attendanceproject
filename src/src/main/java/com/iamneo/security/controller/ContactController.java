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

import org.springframework.web.bind.annotation.RestController;

import com.iamneo.security.entity.Contact;

import com.iamneo.security.service.ContactApiService;

@RestController
@CrossOrigin(origins="*")
public class ContactController {
    @Autowired
    private ContactApiService apiService;
    @GetMapping("/cont/")
    public List<Contact> getAllStudents() {
        return apiService.getAllStudents2();
    }
    @GetMapping("/cont/{id}")
    public Contact getStudentById(@PathVariable Integer id) {
        return apiService.getStudentById2(id);
    }
    @PostMapping("/cont")
    public boolean createStudent(@RequestBody Contact student) {
        return apiService.createStudent2(student);
    }
    @PutMapping("/cont/{id}")
    public Contact updateStudent( @RequestBody Contact student,@PathVariable Integer id) {
        return apiService.updateStudent2(id, student);
    }
    @DeleteMapping("/cont/{id}")
    public boolean deleteStudent(@PathVariable Integer id) {
       return apiService.deleteStudent2(id);
    }
}