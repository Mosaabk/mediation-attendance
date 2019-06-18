<<<<<<< HEAD
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
=======
package com.waa.dragons.mediationattendance.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class TMChecking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    private String teacher;



}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
