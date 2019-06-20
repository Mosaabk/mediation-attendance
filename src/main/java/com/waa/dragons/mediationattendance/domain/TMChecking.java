package com.waa.dragons.mediationattendance.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class TMChecking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    private String teacher;

    //add code

    @ManyToOne
    private Student student;



}
