package com.iamneo.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.security.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
   
}