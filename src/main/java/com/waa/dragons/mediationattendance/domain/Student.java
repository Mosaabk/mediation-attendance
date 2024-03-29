package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String studentId;
    private String barCode;

    @ManyToOne
    private Entry entry;


    @ManyToMany
    private List<Section> sections;

//    private LocalDate entry;

    @OneToMany(mappedBy = "student", cascade={CascadeType.PERSIST, CascadeType.MERGE})

    private List<Attendance> attendances;
    //add code

    @OneToMany
    private List<TMChecking> tmCheckings=new ArrayList<>();

    @OneToMany
    private List<TMRetreat>tmRetreats=new ArrayList<>();

}
