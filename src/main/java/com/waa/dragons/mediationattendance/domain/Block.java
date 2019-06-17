package com.waa.dragons.mediationattendance.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Block {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private LocalDate startDate;

    private LocalDate endDate;

    private String blockName;



}


