package com.waa.dragons.mediationattendance.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Temporal(TemporalType.DATE)
    private Date date;

    private String location;

    private String type;

    private long barCode;

    @ManyToOne
    private Student student;
}
