package com.waa.dragons.mediationattendance.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TypeTM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String typeName;//EAM or AM
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "typeTM", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MeditationRecord> meditationRecords;

}
