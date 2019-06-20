package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Section;

import java.util.List;

public interface SectionService {

    List<Section> findAll();
    List<Section> findAllByStudentList_studentId(String studentId);

}
