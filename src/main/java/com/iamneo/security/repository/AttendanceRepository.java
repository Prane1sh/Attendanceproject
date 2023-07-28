package com.iamneo.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iamneo.security.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	@Query(value = "SELECT * FROM Attendance WHERE date = ?1", nativeQuery = true)
    List<Attendance>findAttendanceByDate(String date);
   
}
