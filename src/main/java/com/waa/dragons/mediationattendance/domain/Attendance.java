package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Date;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private HashMap<Date, Boolean> attendances;
    private int totalSessionsPossible;
    private int totalSessionsAttended;
    private double percentAttendance;


    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany
    private List<Block> blocks;



    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "attendance")
    private List<MeditationRecord> meditationRecords;


}
