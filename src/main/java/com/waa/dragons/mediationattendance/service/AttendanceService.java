<<<<<<< HEAD
package com.waa.dragons.mediationattendance.service;

public interface AttendanceService {
    double getTotalAttendancePercentage();

}
=======
package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Attendance;

import java.util.List;

public interface AttendanceService {

    double getTotalAttendancePercentage();

    Attendance save(Attendance attendance);
    List<Attendance> saveAll(List<Attendance> attendances);

}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
