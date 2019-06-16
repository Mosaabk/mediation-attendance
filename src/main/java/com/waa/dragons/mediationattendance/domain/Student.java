package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

//    private LocalDate entry;



    @OneToMany
    private List<Attendance> attendances;

    @OneToMany
    private List<TMChecking> tmCheckings;

    @OneToMany
    private List<TMRetreat> tmRetreats;



}
