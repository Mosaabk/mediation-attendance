<<<<<<< HEAD
package com.waa.dragons.mediationattendance.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class TMRetreat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
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
public class TMRetreat {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;




}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
