package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
=======
import java.util.Date;
>>>>>>> mk

@Entity
@Data
@NoArgsConstructor
public class AttendanceReport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<BlockSession> blockSession;
    private HashMap<Date, Boolean> attendances;
    private int totalSessionsPossible;
    private int totalSessionsAttended;
    private double percentAttendance;

<<<<<<< HEAD
    @OneToMany
    private List<Block> blocks;
=======
    @Temporal(TemporalType.DATE)
    private Date date;
>>>>>>> mk


    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "attendance")
    private List<MeditationRecord> meditationRecords;


}
