package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Attendance;

import java.util.List;

public interface AttendanceService {

    Attendance findAttendanceByID(Long id);
    double getTotalAttendancePercentage();

    Attendance save(Attendance attendance);
    List<Attendance> saveAll(List<Attendance> attendances);

}
