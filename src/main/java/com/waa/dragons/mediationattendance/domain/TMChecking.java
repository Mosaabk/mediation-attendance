package com.waa.dragons.mediationattendance.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class TMChecking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
@Temporal(TemporalType.DATE)
    private Date date;
    @NotNull
    private String teacher;
    @ManyToOne
    private  Student student;



}
