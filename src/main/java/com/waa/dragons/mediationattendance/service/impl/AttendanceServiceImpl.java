package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Student;
import com.waa.dragons.mediationattendance.repository.AttendanceRepository;
import com.waa.dragons.mediationattendance.domain.Attendance;

import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {


    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public double getTotalAttendancePercentage() {
        return 0;
    }




    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> saveAll(List<Attendance> attendances) {
        return null;
    }

    @Override
    public List<Attendance> findAllByStudent(Student student) {
        return  attendanceRepository.findAllByStudent(student);
    }

    @Override
    public List<Attendance> findAllByStudentAndAndBlock(Student student, Block block) {
        return attendanceRepository.findAllByStudentAndAndBlock(student, block);
    }

}
