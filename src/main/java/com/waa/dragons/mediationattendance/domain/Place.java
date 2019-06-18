<<<<<<< HEAD
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
=======
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
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
