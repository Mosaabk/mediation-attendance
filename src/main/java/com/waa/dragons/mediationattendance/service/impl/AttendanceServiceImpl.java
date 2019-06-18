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

    public List<Attendance> findAllByStudentAndBlock(Student stu, Block block){
        return (List<Attendance>)attendanceRepository.findAllByStudentAndBlock(stu, block);
    }

    public List<Attendance> findAllByStudent(Student stu){
        return (List<Attendance>) attendanceRepository.findAllByStudent(stu);
    }



}
