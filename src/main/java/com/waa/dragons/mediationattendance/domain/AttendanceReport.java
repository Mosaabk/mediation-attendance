package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.time.LocalDate;
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
    private List<BlockSession> blockSession;
    private HashMap<Date, Boolean> attendances;
    private int totalSessionsPossible;
    private int totalSessionsAttended;
    private double percentAttendance;

    @ManyToOne
    private Student student;

    private LocalDate date;

    @ManyToOne
    private Block block;

    @ManyToOne
    private Place place;



    private String type;


}