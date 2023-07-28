package com.iamneo.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.security.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
   
}