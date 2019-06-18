package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String studentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    @OneToMany(mappedBy = "student", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<MeditationRecord> meditationRecords;


}
