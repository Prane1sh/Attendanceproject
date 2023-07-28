package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
