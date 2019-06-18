package com.waa.dragons.mediationattendance.service.impl;
<<<<<<< HEAD:src/main/java/com/waa/dragons/mediationattendance/service/impl/AttendanceServiceImpl.java
import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Student;
=======

>>>>>>> 1a9eb7e425d73ea27c783219fda16353a959ae75:src/main/java/com/waa/dragons/mediationattendance/service/impl/AttendanceResponseServiceImpl.java
import com.waa.dragons.mediationattendance.repository.AttendanceRepository;
import com.waa.dragons.mediationattendance.domain.Attendance;

import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceResponseServiceImpl implements AttendanceService {


    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public double getTotalAttendancePercentage() {
        return 0;
    }




    @Override
    public Attendance save(Attendance attendance) {
        return null;
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
