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
    private int id;

    @OneToMany
    private List<BlockSession> blockSession;
    private HashMap<Date, Boolean> attendances;
    private int totalSessionsPossible;
    private int totalSessionsAttended;
    private double percentAttendance;

    @OneToMany
    private List<Block> blocks;


    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "attendance")
    private List<MeditationRecord> meditationRecords;


}
