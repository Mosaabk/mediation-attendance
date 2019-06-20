package com.waa.dragons.mediationattendance.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBlockAttendanceReport {

    private String studentName;
    private int daysPresent;
    private double attendancePercentage;
    private int daysAvailable;
    private double extraPoints;


}
