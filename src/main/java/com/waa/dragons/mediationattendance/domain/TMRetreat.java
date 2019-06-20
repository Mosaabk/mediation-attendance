package com.waa.dragons.mediationattendance.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class TMRetreat {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    //add code
    @ManyToOne
    private Student student;





}
