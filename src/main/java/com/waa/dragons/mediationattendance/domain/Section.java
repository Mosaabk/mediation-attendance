package com.waa.dragons.mediationattendance.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    private Course course;

    @ManyToOne
    private Block block;

    @OneToOne
    private Faculty faculty;

    @ManyToMany(mappedBy = "sections")
    private List<Student> studentList;


}
