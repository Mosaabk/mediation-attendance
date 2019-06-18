package com.waa.dragons.mediationattendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class AttendanceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Block> blocks;

   // private  String blockName;

    private HashMap<Date, Boolean> attendanceDates;

    private double attendancePercentage;

    private double extraCreditPoints;

    //added code


}
