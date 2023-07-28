package com.iamneo.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.security.entity.Attendance;
import com.iamneo.security.repository.AttendanceRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
    public List<Attendance> getAttendanceByFilter(String date) {
        return attendanceRepository.findAttendanceByDate(date);
    }


    public Attendance getAttendanceById(Long id) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findById(id);
        return attendanceOptional.orElse(null);
    }

    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findById(id);
        if (attendanceOptional.isPresent()) {
            Attendance attendance = attendanceOptional.get();
            attendance.setDate(updatedAttendance.getDate());
            attendance.setStatus(updatedAttendance.getStatus());
            attendance.setSession(updatedAttendance.getSession());
            attendance.setTeacherId(updatedAttendance.getTeacherId());
            // You may set other attributes here if needed.

            return attendanceRepository.save(attendance);
        }
        return null;
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
