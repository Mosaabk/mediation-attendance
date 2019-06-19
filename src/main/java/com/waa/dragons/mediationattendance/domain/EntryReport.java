package com.waa.dragons.mediationattendance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;


    private HashMap<String, StudentBlockAttendanceReport> blockAttendances;
}
