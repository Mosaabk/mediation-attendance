package com.waa.dragons.mediationattendance.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalStudentAttendanceReport {

    private int totalSessionsPossible;
    private int totalSessionsAttended;
    private double totalAttendancePercentage;

}
