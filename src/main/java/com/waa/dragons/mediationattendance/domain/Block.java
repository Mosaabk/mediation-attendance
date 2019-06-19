package com.waa.dragons.mediationattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private LocalDate startDate;

    private LocalDate endDate;

    private String blockName;

}


