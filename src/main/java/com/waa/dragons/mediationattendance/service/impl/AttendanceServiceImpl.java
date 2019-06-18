package com.waa.dragons.mediationattendance.service.impl;

import com.waa.dragons.mediationattendance.repository.AttendanceRepository;
import com.waa.dragons.mediationattendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public double getTotalAttendancePercentage() {
        return 0;
    }
}
