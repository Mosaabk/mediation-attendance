package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Attendance;
import com.waa.dragons.mediationattendance.domain.Block;
import com.waa.dragons.mediationattendance.domain.Student;

import java.util.List;

public interface AttendanceService {

    double getTotalAttendancePercentage();

    Attendance save(Attendance attendance);
    List<Attendance> saveAll(List<Attendance> attendances);
    List<Attendance> findAllByStudentAndBlock(Student stu, Block block);
    List<Attendance> findAllByStudent(Student stu);

}
