package com.waa.dragons.mediationattendance.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String placeId;
    private String placeName;

    @OneToMany
    private List<MeditationRecord> meditationRecords;
}
