<<<<<<< HEAD
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
=======
package com.waa.dragons.mediationattendance.service.impl;
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

}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
