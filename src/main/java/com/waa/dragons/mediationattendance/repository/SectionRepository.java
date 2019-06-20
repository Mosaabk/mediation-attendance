package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends CrudRepository<Section, Long> {

    List<Section> findAll();
    List<Section> findAllByStudentList_studentId(String studentId);
}
