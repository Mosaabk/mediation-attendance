package com.waa.dragons.mediationattendance.domain;

<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Date;


import java.util.Date;
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953

@Entity
@Data
@NoArgsConstructor
public class Attendance {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
=======

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private Student student;

    private LocalDate date;

    @ManyToOne
    private Block block;

    @ManyToOne
    private Place place;



    private String type;


>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
}
