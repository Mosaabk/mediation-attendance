package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private LocalDate date;

    private String location;

    private String type;

    private long barCode;

    @ManyToOne
    private Student student;
}
