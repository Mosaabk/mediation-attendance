package com.waa.dragons.mediationattendance.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Block {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "block")
    private List<BlockSession> blockSession;

    private LocalDate startDate;

    private LocalDate endDate;

    private String blockName;

}


